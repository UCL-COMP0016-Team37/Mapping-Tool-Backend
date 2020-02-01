package uk.ac.ucl.mappingtool.v2.domain.activityStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityStatus {
    private String code;
    private String name;
}
