package uk.ac.ucl.mappingtool.v2.domain.map.flowMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.coordinate.Coordinate;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.BudgetQueryItem;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.Organisation;
import uk.ac.ucl.mappingtool.v2.domain.transaction.Transaction;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funding {
    private BudgetQueryItem<Organisation> transaction;
    private Coordinate from;
    private Coordinate to;
}
