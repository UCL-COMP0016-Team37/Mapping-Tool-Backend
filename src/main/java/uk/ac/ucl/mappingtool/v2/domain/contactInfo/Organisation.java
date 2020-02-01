package uk.ac.ucl.mappingtool.v2.domain.contactInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.narrative.Narrative;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organisation {
    private List<Narrative> narratives;
}
