package uk.ac.ucl.mappingtool.v2.domain.analysis.response.FundingToGraph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FundingToCountry {
    private Integer countryNum;
    private List<CountryItem> tops; // top 4
    private CountryItem rest; // rest of all
}
