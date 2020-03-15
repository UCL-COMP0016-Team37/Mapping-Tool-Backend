package uk.ac.ucl.mappingtool.v2.domain.analysis.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Query {
    private Integer count;
    private List<QueryItem> results;
}
