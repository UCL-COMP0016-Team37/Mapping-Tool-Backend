package uk.ac.ucl.mappingtool.v2.domain.analysis.response.budgetToGraph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.analysis.response.CountryItem;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetToCountry {
    private Integer countryNum;
    private List<CountryItem> tops; // top 4
    private CountryItem rest; // rest of all
}
