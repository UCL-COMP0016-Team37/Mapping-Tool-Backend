package uk.ac.ucl.mappingtool.v2.domain.activity.budget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.type.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Budget {
    private String activity_id;
    private Type type;
    private Type status;
    private String period_start;
    private String period_end;
    private Value value;

    // convert to other currency
    private String xdr_value;
    private String usd_value;
    private String eur_value;
    private String gbp_value;
    private String jpy_value;
    private String cad_value;
}
