package uk.ac.ucl.mappingtool.v2.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.recipientCountry.RecipientCountry;
import uk.ac.ucl.mappingtool.v2.domain.recipientRegion.RecipientRegion;
import uk.ac.ucl.mappingtool.v2.domain.activitySector.ActivitySector;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    private String iati_identifier;
    private List<RecipientCountry> recipient_countries;
    private List<RecipientRegion> recipient_regions;
    private List<ActivitySector> sectors;
}
