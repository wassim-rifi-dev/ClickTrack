package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.model.Publisher;
import ma.youcode.clicktrack.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImp implements PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherServiceImp(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher create(Publisher publisher) {
        publisherRepository.save(publisher);
        return publisher;
    }

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher getById(Long id) {
        return publisherRepository.findById(id);
    }
}
