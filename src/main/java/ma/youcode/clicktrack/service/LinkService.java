package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.model.Link;

import java.util.List;

public interface LinkService extends Service<Link> {
    List<Link> getByPublisherId(Long publisherId);

    void addClick(Long id);
}
