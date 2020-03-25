package uk.ac.ucl.mappingtool.v2.domain.map.flowMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.BudgetQueryItem;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.Organisation;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryFlow {
    private String destinationCode;
    private List<Funding> funding;
}
