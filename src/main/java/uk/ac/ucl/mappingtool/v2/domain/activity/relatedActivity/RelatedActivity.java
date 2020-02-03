package uk.ac.ucl.mappingtool.v2.domain.activity.relatedActivity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.activity.type.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelatedActivity {
    private String ref_activity;
    private String ref_activity_id;
    private String ref;
    private Type type;
}
