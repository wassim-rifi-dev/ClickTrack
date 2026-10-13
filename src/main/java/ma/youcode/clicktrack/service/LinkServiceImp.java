package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.dto.responce.PublisherLinkResponceDTO;
import ma.youcode.clicktrack.model.Link;
import ma.youcode.clicktrack.repository.LinkRepository;

import java.util.List;
import java.util.stream.Collectors;

public class LinkServiceImp implements LinkService {
    private final LinkRepository linkRepository;

    public LinkServiceImp(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public List<PublisherLinkResponceDTO> getByPublisherId(Long publisherId) {
        List<Link> links = linkRepository.findByPublisherId(publisherId);

        List<PublisherLinkResponceDTO> publisherLinks = links.stream()
                .collect(Collectors.groupingBy(Link::getOffre))
                .entrySet().stream()
                .map(entry -> new PublisherLinkResponceDTO(
                        entry.getKey(),
                        entry.getValue().size(),
                        entry.getValue().stream().mapToInt(Link::getClicks).sum()
                ))
                .toList();

        return publisherLinks;
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
