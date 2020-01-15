package uk.ac.ucl.mappingtool.test.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ApiModel(description = "User Model")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @ApiModelProperty("User id")
    private Long id;

    @Column(nullable = false)
    @ApiModelProperty("User Name")
    private String name;

    @Column(nullable = false)
    @ApiModelProperty("User Age")
    private Integer age;

    public User(String name, Integer age){
        this.name = name;
        this.age = age;
    }

}


