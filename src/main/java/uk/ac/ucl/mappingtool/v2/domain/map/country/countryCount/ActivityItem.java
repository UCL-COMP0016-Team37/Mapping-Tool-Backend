package uk.ac.ucl.mappingtool.v2.domain.map.country.countryCount;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.activity.activitySector.ActivitySector;
import uk.ac.ucl.mappingtool.v2.domain.activity.recipientCountry.RecipientCountry;
import uk.ac.ucl.mappingtool.v2.domain.activity.recipientRegion.RecipientRegion;

import java.util.List;

/**
 * This is different from main 'Activity' model for Activity Controller
 * This is only used for the return result for country total activity count
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityItem {
    private String iati_identifier;
//    private List<RecipientCountry> recipient_countries;
//    private List<RecipientRegion> recipient_regions;
//    private List<ActivitySector> sectors;
}
