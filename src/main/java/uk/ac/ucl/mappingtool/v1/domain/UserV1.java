package uk.ac.ucl.mappingtool.v1.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@ApiModel(description = "User Model")
@Table(name = "user")
public class UserV1 {
    public UserV1() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty("User id")
    private Integer id;

    @Column(nullable = false)
    @ApiModelProperty("User name")
    private String username;

    @Column(nullable = false)
    @ApiModelProperty("User sex")
    private String sex;

    @Column(nullable = false)
    @ApiModelProperty("User address")
    private String address;
}

