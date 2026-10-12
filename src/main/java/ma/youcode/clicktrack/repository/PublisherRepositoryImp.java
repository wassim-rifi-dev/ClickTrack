package ma.youcode.clicktrack.repository;

import ma.youcode.clicktrack.model.Publisher;

import java.util.ArrayList;
import java.util.List;

public class PublisherRepositoryImp implements PublisherRepository {
    private final List<Publisher> publishers = new ArrayList<>();

    @Override
    public void save(Publisher publisher) {

    }

    @Override
    public List<Publisher> findAll() {
        return List.of();
    }

    @Override
    public Publisher findById(Long id) {
        return null;
    }
}
