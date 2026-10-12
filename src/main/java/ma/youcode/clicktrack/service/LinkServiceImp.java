package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.model.Link;
import ma.youcode.clicktrack.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImp implements LinkService {
    private final LinkRepository linkRepository;

    public LinkServiceImp(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public List<Link> getByPublisherId(Long publisherId) {
        return List.of();
    }

    @Override
    public void addClick(Long id) {

    }

    @Override
    public Link create(Link link) {
        boolean isCreated = linkRepository.save(link);

        if (!isCreated) {
            return null;
        }

        return link;
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
