package uk.ac.ucl.mappingtool.v2.domain.activity.description;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.narrative.Narrative;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.type.Type;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Description {
    private Type type;
    private List<Narrative> narratives;
}
