package uk.ac.ucl.mappingtool.test.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@ApiModel(description = "User Model")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @ApiModelProperty("User id")
    private Long id;

    @ApiModelProperty("User Name")
    private String name;

    @ApiModelProperty("User Age")
    private Integer age;
}


