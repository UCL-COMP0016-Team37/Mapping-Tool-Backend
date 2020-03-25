package uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.BudgetQueryItem;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetQuery<T> {
    private Integer count;
    private List<BudgetQueryItem<T>> results;
}
