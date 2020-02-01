package uk.ac.ucl.mappingtool.v2.domain.description;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.narrative.Narrative;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Description {
    private Type type;
    private List<Narrative> narratives;
}
