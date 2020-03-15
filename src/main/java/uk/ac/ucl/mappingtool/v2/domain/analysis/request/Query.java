package uk.ac.ucl.mappingtool.v2.domain.analysis.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Query<T> {
    private Integer count;
    private List<QueryItem<T>> results;
}
