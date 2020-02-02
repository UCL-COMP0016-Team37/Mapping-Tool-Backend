package uk.ac.ucl.mappingtool.v2.domain.title;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.narrative.Narrative;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Title {
    List<Narrative> narratives;
}
