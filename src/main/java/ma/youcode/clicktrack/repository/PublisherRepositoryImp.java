package ma.youcode.clicktrack.repository;

import ma.youcode.clicktrack.model.Publisher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PublisherRepositoryImp implements PublisherRepository {
    private final List<Publisher> publishers = new ArrayList<>();

    @Override
    public boolean save(Publisher publisher) {
        return publishers.add(publisher);
    }

    @Override
    public List<Publisher> findAll() {
        return publishers;
    }

    @Override
    public Publisher findById(Long id) {
        return null;
    }
}
