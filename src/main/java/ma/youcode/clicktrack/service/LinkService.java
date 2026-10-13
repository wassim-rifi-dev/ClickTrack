package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.dto.responce.OffreStatsDTO;
import ma.youcode.clicktrack.dto.responce.PublisherLinkResponceDTO;
import ma.youcode.clicktrack.dto.responce.PublisherOffresDTO;
import ma.youcode.clicktrack.model.Link;

import java.util.List;
import java.util.Map;

public interface LinkService extends Service<Link> {
    List<PublisherLinkResponceDTO> getByPublisherId(Long publisherId);

    PublisherOffresDTO getPublisherOffer(Long publisherId);

    void addClick(Long id);
}
