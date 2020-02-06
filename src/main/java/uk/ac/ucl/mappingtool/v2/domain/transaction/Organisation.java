package uk.ac.ucl.mappingtool.v2.domain.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.narrative.Narrative;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.type.Type;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organisation {
    private String ref;
    private Type type;
    private String provider_activity;
    private String provider_activity_id;
    private List<Narrative> narratives;
}
