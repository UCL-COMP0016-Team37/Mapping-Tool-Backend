package uk.ac.ucl.mappingtool.v2.domain.analysis.request;


import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryItem<T> {
    @SerializedName(value = "recipient_country", alternate = {"sector","receiver_org"})
    private T group;  // can be changed to what you want to group
    private Integer activity_count;
    private Double value;
}
