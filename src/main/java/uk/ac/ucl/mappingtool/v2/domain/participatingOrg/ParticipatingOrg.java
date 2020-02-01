package uk.ac.ucl.mappingtool.v2.domain.participatingOrg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.narrative.Narrative;

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
