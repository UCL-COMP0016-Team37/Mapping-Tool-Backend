package uk.ac.ucl.mappingtool.v2.domain.publisher;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "publishers")
public class Publisher {
    @Id
    @ApiModelProperty("Publisher Unique ID from IATI standard")
    @SerializedName("IATI Organisation Identifier")
    private String id;

    @Column(nullable = false, name = "country_code")
    private String countryCode;

    @Column(nullable = false, name = "org_headquarter")
    @SerializedName("HQ Country or Region")
    private String hq;

    @Column(nullable = false, name = "org_name")
    @SerializedName("Publisher")
    private String name;

    @Column(name = "org_type")
    @SerializedName("Organization Type")
    private String type;


    @Column(name = "dataset_count")
    @SerializedName("Datasets Count")
    private String datasetNum;

    @Column(name = "dataset_link")
    @SerializedName("Datasets Link")
    private String link;
}
