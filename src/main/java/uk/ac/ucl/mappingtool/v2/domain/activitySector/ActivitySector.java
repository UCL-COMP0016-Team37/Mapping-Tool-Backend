package uk.ac.ucl.mappingtool.v2.domain.activitySector;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.narrative.Narrative;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivitySector {
    private Sector sector;
    private Integer percentage;
    private Vocabulary vocabulary;
    private String vocabulary_uri;
    private List<Narrative> narratives;

}
