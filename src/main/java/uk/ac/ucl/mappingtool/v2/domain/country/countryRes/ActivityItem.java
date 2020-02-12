package uk.ac.ucl.mappingtool.v2.domain.country.countryRes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
