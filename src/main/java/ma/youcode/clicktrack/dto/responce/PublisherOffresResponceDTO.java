package ma.youcode.clicktrack.dto.responce;

import java.util.List;

public record PublisherOffresResponceDTO(
        String publisher,
        List<OffreStatsDTO> offres
) { }
