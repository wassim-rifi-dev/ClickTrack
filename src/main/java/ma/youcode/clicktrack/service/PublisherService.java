package ma.youcode.clicktrack.service;

import ma.youcode.clicktrack.dto.responce.PublisherOffresResponceDTO;
import ma.youcode.clicktrack.model.Publisher;

public interface PublisherService extends Service<Publisher> {
    PublisherOffresResponceDTO getPublisherOffer(Long publisherId);
}
