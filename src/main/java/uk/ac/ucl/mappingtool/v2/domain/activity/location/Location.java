package uk.ac.ucl.mappingtool.v2.domain.activity.location;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.activity.defaultAidType.DefaultAidType;
import uk.ac.ucl.mappingtool.v2.domain.activity.description.Description;
import uk.ac.ucl.mappingtool.v2.domain.activity.reportingOrg.ReportingOrg;
import uk.ac.ucl.mappingtool.v2.domain.activity.script.Script;
import uk.ac.ucl.mappingtool.v2.domain.activity.type.Type;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    private String iati_identifier;
    private String ref;
    private LocationReach location_reach;
    private LocationId location_id;
    private Script name;
    private Script description;
    private Script activity_description;
    private List<Administrative> administrative;
    private Point point;
    private Exactness exactness;
    private LocationClass location_class;
    private Type feature_designation;
    private List<ReportingOrg> reporting_organisations;
    private DefaultAidType default_aid_type;
}
