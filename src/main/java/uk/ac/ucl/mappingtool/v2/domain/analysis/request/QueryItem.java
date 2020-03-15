package uk.ac.ucl.mappingtool.v2.domain.analysis.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryItem {
    private RecipientCountry recipient_country;
    private Integer activity_count;
    private Double value;
}
