package uk.ac.ucl.mappingtool.v2.domain.analysis.request.activity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityQueryItem<T>{
    @SerializedName(value = "reporting_organisation", alternate = {"sector"})
    private T group;
    private Integer count;
}
