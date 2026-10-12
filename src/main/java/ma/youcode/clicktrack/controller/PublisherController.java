package ma.youcode.clicktrack.controller;

import ma.youcode.clicktrack.model.Publisher;
import ma.youcode.clicktrack.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public ResponseEntity<?> getAllPublishers() {
        List<Publisher> publishers = publisherService.getAll();

        if (publishers.isEmpty()) {
            return ResponseEntity.ok(
                    Map.of("message" , "Aucun publisher n'existe")
            );
        }

        return ResponseEntity.ok(publishers);
    }
}
