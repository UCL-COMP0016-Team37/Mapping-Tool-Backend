package uk.ac.ucl.mappingtool.v2.domain.otherIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.narrative.Narrative;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerOrg {
    private String ref;
    private List<Narrative> narratives;
}
