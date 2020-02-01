package uk.ac.ucl.mappingtool.v2.domain;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.activityScope.ActivityScope;
import uk.ac.ucl.mappingtool.v2.domain.activityStatus.ActivityStatus;
import uk.ac.ucl.mappingtool.v2.domain.recipientCountry.RecipientCountry;
import uk.ac.ucl.mappingtool.v2.domain.recipientRegion.RecipientRegion;
import uk.ac.ucl.mappingtool.v2.domain.activitySector.ActivitySector;
import uk.ac.ucl.mappingtool.v2.domain.reportingOrg.ReportingOrg;

import java.util.List;


/**
 * Default activity POJO
 * N.B. Must add @JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY) to possible null entities
 * Non successful mapping entities will be automatically set as theirs default value
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
    private Boolean humanitarian;
    private Integer hierarchy;
    private ActivityStatus activity_status;
    private ActivityScope activity_scope;
    private ReportingOrg reporting_org;
}
