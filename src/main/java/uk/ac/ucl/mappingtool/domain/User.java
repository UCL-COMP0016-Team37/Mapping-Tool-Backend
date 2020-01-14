package uk.ac.ucl.mappingtool.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "User Model")
@Data
public class User {
    @ApiModelProperty("User id")
    private Long id;
    @ApiModelProperty("User Name")
    private String name;
    @ApiModelProperty("User Age")
    private Integer age;

}


