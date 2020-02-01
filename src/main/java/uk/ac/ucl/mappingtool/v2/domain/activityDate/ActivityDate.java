package uk.ac.ucl.mappingtool.v2.domain.activityDates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.narrative.Narrative;
import uk.ac.ucl.mappingtool.v2.domain.type.Type;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDate {
    private String iso_date;
    private Type type;
    private List<Narrative> narratives;
}
