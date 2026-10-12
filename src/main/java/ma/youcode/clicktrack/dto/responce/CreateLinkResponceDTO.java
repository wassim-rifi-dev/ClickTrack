package ma.youcode.clicktrack.dto.responce;

public record CreateLinkResponceDTO(
   Long id,
   String offre,
   String urlDestination,
   int clicks,
   String publisher,
   String link
) {}
