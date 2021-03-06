package uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.script;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.narrative.Narrative;

import java.util.List;


/**
 * This domain class is for all scripting patterns
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Script {
    private List<Narrative> narratives;
}
