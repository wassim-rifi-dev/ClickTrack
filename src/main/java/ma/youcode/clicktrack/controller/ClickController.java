package ma.youcode.clicktrack.controller;

import ma.youcode.clicktrack.model.Link;
import ma.youcode.clicktrack.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/t")
public class ClickController {

    public final LinkService linkService;

    public ClickController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> addClick(@PathVariable("id") Long linkId) {
        Link link = linkService.getById(linkId);

        if (link == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Link introuvable avec l'id " + linkId));
        }

        Link linkAfterClick = linkService.addClick(link);

        return ResponseEntity.ok(linkAfterClick);
    }
}
