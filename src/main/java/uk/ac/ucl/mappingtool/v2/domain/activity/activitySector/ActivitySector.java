package uk.ac.ucl.mappingtool.v2.domain.activity.activitySector;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.activity.narrative.Narrative;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivitySector {
    private Sector sector;
    private Double percentage;
    private Vocabulary vocabulary;
    private String vocabulary_uri;
    private List<Narrative> narratives;

}
