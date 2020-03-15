package uk.ac.ucl.mappingtool.v2.domain.analysis.response.FundingToGraph;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryItem {
    private String name;
    private Long number;
    private Double percentage;
}
