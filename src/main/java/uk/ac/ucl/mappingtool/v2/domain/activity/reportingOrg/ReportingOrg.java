package uk.ac.ucl.mappingtool.v2.domain.activity.reportingOrg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.narrative.Narrative;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.type.Type;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportingOrg {
    private String ref;
    private String url;
    private Type type;
    private Boolean secondary_reporter;
    private List<Narrative> narratives;
}
