package uk.ac.ucl.mappingtool.v2.domain.activity.budget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.activity.type.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Value {
    private Type currency;
    private String date;
    private Double value;
}
