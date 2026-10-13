package ma.youcode.clicktrack.dto.responce;

import java.util.List;

public record PublisherOffresDTO(
        Long publisherId,
        List<OffreStatsDTO> offres
) { }
