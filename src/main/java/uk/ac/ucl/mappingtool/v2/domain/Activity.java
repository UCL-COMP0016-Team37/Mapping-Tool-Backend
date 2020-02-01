package uk.ac.ucl.mappingtool.v2.domain;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.recipientCountry.RecipientCountry;
import uk.ac.ucl.mappingtool.v2.domain.recipientRegion.RecipientRegion;
import uk.ac.ucl.mappingtool.v2.domain.activitySector.ActivitySector;

import java.util.List;


/**
 * Default activity POJO
 * N.B. Must add @JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY) to possible null entities
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

    // default entries
    private String iati_identifier;
    private List<RecipientCountry> recipient_countries;
    @JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY)
    private List<RecipientRegion> recipient_regions;
    @JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY)
    private List<ActivitySector> sectors;

    // additional entries
//    private boolean humanitarian;
}
