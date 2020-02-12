package uk.ac.ucl.mappingtool.v2.domain.activity.participatingOrg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.narrative.Narrative;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.type.Type;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipatingOrg {
    private String ref;
    private Type type;
    private Role role;
    private String activity_id;
    private List<Narrative> narratives;
}
