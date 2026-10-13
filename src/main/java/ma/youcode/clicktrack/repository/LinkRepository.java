package ma.youcode.clicktrack.repository;

import ma.youcode.clicktrack.model.Link;

import java.util.List;

public interface LinkRepository extends Repository<Link> {
    List<Link> findByPublisherId(Long publisherId);

    Link incrementClicks(Link link);
}
