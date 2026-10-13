package ma.youcode.clicktrack.controller;

import ma.youcode.clicktrack.dto.request.CreateLinkRequestDTO;
import ma.youcode.clicktrack.dto.responce.CreateLinkResponceDTO;
import ma.youcode.clicktrack.dto.responce.PublisherLinkResponceDTO;
import ma.youcode.clicktrack.model.Link;
import ma.youcode.clicktrack.model.Publisher;
import ma.youcode.clicktrack.service.LinkService;
import ma.youcode.clicktrack.service.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/publishers")
public class LinkController {

    private final LinkService linkService;
    private final PublisherService publisherService;

    public LinkController(LinkService linkService, PublisherService publisherService) {
        this.linkService = linkService;
        this.publisherService = publisherService;
    }

    private final AtomicLong linkId = new AtomicLong(0);

    @PostMapping("/{id}/liens")
    public ResponseEntity<?> createLink(@RequestBody CreateLinkRequestDTO createLinkDTO , @PathVariable("id") Long publisherId) {
        if (createLinkDTO == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "Donner les info de lien created"));
        }

        if (createLinkDTO.offre() == null || createLinkDTO.urlDestination() == null || createLinkDTO.urlDestination().isBlank()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "L'offre et l'urlDestination sont obligatoires"));
        }

        Publisher publisher = publisherService.getById(publisherId);

        if (publisher == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Publisher introuvable avec l'id " + publisherId));
        }

        Link link = new Link(
                linkId.incrementAndGet(),
                createLinkDTO.offre(),
                createLinkDTO.urlDestination(),
                0,
                publisher
        );

        Link savedLink  = linkService.create(link);

        if (savedLink == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Erreur lors de la création du lien"));
        }

        CreateLinkResponceDTO responceDTO = new CreateLinkResponceDTO(
                savedLink.getId(),
                savedLink.getOffre(),
                savedLink.getUrlDestination(),
                savedLink.getClicks(),
                savedLink.getPublisher().getFullName(),
                "/t/" + savedLink.getId()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(responceDTO);

    }

    @GetMapping("/{id}/liens")
    public ResponseEntity<?> getPublisherLink(@PathVariable("id") Long publisherId) {
        Publisher publisher = publisherService.getById(publisherId);

        if (publisher == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Publisher introuvable avec l'id " + publisherId));
        }

        List<PublisherLinkResponceDTO> publisherLinks = linkService.getByPublisherId(publisher.getId());

        if (publisherLinks.isEmpty()) {
            return ResponseEntity.ok(
                    Map.of("message", "Aucun lien trouvé pour ce publisher")
            );
        }

        return ResponseEntity.ok(publisherLinks);
    }
}
