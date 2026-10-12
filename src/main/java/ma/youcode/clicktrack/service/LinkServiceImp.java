package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.model.Link;

import java.util.List;

public class LinkServiceImp implements LinkService{
    @Override
    public List<Link> getByPublisherId(Long publisherId) {
        return List.of();
    }

    @Override
    public void addClick(Long id) {

    }

    @Override
    public Link create(Link link) {
        return null;
    }

    @Override
    public List<Link> getAll() {
        return List.of();
    }

    @Override
    public Link getById(Long id) {
        return null;
    }
}
