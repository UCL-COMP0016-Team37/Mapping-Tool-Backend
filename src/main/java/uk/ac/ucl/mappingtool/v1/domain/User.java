package uk.ac.ucl.mappingtool.v1.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "User Model")
@Table(name = "user")
public class User {

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

