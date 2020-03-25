package uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organisation {
    @SerializedName(value = "organisation_identifier")
    private String id;
    @SerializedName(value = "primary_name")
    private String name;
    private String url;
}
