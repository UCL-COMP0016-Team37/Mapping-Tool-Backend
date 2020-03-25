package uk.ac.ucl.mappingtool.v2.domain.analysis.request.activity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class ActivityQuery<T>{
    private Integer count;
    private List<ActivityQueryItem<T>> results;
}
