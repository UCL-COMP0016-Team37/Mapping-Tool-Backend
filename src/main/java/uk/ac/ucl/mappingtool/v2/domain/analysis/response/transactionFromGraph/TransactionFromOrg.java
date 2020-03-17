package uk.ac.ucl.mappingtool.v2.domain.analysis.response.transactionFromGraph;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.CountryItem;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionFromOrg {
    private Integer orgNum;
    private List<CountryItem> tops; // top 4
    private CountryItem rest; // rest of all
}
