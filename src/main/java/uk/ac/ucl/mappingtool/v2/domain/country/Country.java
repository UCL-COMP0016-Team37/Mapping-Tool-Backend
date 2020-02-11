package uk.ac.ucl.mappingtool.v2.domain.country;


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
@Table(name = "countries")
public class Country {
    @Id
    @ApiModelProperty("Country Code from iati standard")
    private String code;

    @Column
    private String name;
    @Column
    private String url;
    @Column
    private String longitude;
    @Column
    private String latitude;
    @Column(name = "total_projects")
    private Integer count;
}
