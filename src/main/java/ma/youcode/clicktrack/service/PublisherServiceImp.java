package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.dto.responce.OffreStatsDTO;
import ma.youcode.clicktrack.dto.responce.PublisherOffresDTO;
import ma.youcode.clicktrack.model.Link;
import ma.youcode.clicktrack.model.Publisher;
import ma.youcode.clicktrack.repository.LinkRepository;
import ma.youcode.clicktrack.repository.PublisherRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PublisherServiceImp implements PublisherService {
    private final PublisherRepository publisherRepository;
    private final LinkRepository linkRepository;

    public PublisherServiceImp(PublisherRepository publisherRepository, LinkRepository linkRepository) {
        this.publisherRepository = publisherRepository;
        this.linkRepository = linkRepository;
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

    @Override
    public PublisherOffresDTO getPublisherOffer(Long publisherId) {
        List<Link> links = linkRepository.findByPublisherId(publisherId);

        Map<String, Integer> clicksParOffre = links.stream()
                .collect(Collectors.groupingBy(
                        link -> link.getOffre(),
                        LinkedHashMap::new,
                        Collectors.summingInt(Link::getClicks)
                ));

        List<OffreStatsDTO> offres = clicksParOffre.entrySet().stream()
                .map(e -> new OffreStatsDTO(e.getKey(), e.getValue()))
                .toList();

        return new PublisherOffresDTO(publisherId, offres);
    }
}
