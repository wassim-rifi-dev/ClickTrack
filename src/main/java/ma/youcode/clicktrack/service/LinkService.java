package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.dto.responce.PublisherLinkResponceDTO;
import ma.youcode.clicktrack.model.Link;

import java.util.List;

public interface LinkService extends Service<Link> {
    List<PublisherLinkResponceDTO> getByPublisherId(Long publisherId);

    List<Link> getPublisherOffer(Long publisherId);

    void addClick(Long id);
}
