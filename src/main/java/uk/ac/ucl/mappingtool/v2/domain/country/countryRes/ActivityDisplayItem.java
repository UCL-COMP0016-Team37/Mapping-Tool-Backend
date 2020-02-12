package uk.ac.ucl.mappingtool.v2.domain.country.countryRes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.activity.activitySector.ActivitySector;
import uk.ac.ucl.mappingtool.v2.domain.activity.recipientCountry.RecipientCountry;
import uk.ac.ucl.mappingtool.v2.domain.activity.title.Title;

import java.util.List;


/**
 * This is different from main 'Activity' model for Activity Controller
 * This is only used for the return result for displaying a list of 10 activity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDisplayItem {
    private String iati_identifier;
    private Title title;
    private List<RecipientCountry> recipient_countries;
    private List<ActivitySector> sectors;
}
