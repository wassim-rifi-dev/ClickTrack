package ma.youcode.clicktrack.repository;

import ma.youcode.clicktrack.model.Link;

import java.util.ArrayList;
import java.util.List;

public class LinkRepositoryImp implements LinkRepository {
    private final List<Link> links = new ArrayList<>();

    @Override
    public List<Link> findByPublisherId(Long publisherId) {
        return links.stream()
                .filter(link -> link.getPublisher().getId() == publisherId)
                .toList();
    }

    @Override
    public Link incrementClicks(Link link) {
        link.setClicks(link.getClicks() + 1);

        return link;
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
