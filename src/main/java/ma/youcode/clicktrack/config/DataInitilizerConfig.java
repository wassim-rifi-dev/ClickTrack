package ma.youcode.clicktrack.config;

import ma.youcode.clicktrack.model.Publisher;
import ma.youcode.clicktrack.model.enums.Category;
import ma.youcode.clicktrack.service.PublisherService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitilizerConfig {
    private final PublisherService publisherService;

    public DataInitilizerConfig(PublisherService publisherService) {
        this.publisherService = publisherService;
        init();
    }

    public void init() {
        Publisher publisher1 = new Publisher(1L, "Youssef", "Benali", "youssef.benali@gmail.com", Category.INFLUENCER);
        Publisher publisher2 = new Publisher(2L, "Salma", "El Idrissi", "salma.elidrissi@gmail.com", Category.YOUTUBER);
        Publisher publisher3 = new Publisher(3L, "Amine", "Tazi", "amine.tazi@gmail.com", Category.BLOGGER);
        Publisher publisher4 = new Publisher(4L, "Khadija", "Alaoui", "khadija.alaoui@gmail.com", Category.INFLUENCER);

        publisherService.create(publisher1);
        publisherService.create(publisher2);
        publisherService.create(publisher3);
        publisherService.create(publisher4);
    }
}
