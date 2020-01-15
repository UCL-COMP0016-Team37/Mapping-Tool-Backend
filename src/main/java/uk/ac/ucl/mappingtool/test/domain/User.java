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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty("User id")
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty("User Name")
    private String name;

    @Column(nullable = false)
    @ApiModelProperty("User Age")
    private Integer age;
}


