package uk.ac.ucl.mappingtool.v2.domain.publisher;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherReq {
    @SerializedName("IATI Organisation Identifier")
    private String id;
    @SerializedName("Publisher")
    private String name;
    @SerializedName("Organization Type")
    private String type;
    @SerializedName("HQ Country or Region")
    private String hq;
    @SerializedName("Datasets Count")
    private String datasetNum;
    @SerializedName("Datasets Link")
    private String link;
}
