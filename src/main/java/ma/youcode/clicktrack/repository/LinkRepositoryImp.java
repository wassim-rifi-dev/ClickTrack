package ma.youcode.clicktrack.repository;

import ma.youcode.clicktrack.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImp implements LinkRepository {
    private final List<Link> links = new ArrayList<>();

    @Override
    public List<Link> findByPublisherId(Long publisherId) {
        return List.of();
    }

    @Override
    public void incrementClicks(Long id) {

    }

    @Override
    public boolean save(Link link) {
        return links.add(link);
    }

    @Override
    public List<Link> findAll() {
        return List.of();
    }

    @Override
    public Link findById(Long id) {
        return null;
    }
}
