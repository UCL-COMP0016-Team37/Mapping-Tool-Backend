package uk.ac.ucl.mappingtool.v1.domain;


import io.swagger.annotations.ApiModel;
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
@ApiModel(description = "Project Model")
@NoArgsConstructor
@Table(name = "projects")
public class Project {

    @Id
    @ApiModelProperty("Project Unique ID")
    private String interaction_intervention_id;

    @Column(nullable = false)
    private String organization;
    @Column()
    private String org_intervention_id;
    @Column()
    private String project_tags;
    @Column(nullable = false)
    private String project_name;
    @Column()
    private String project_description;
    @Column()
    private String activities;
    @Column()
    private String additional_information;
    @Column()
    private String start_date;
    @Column()
    private String end_date;
    @Column()
    private String sectors;
    @Column()
    private String cross_cutting_issues;
    @Column()
    private String budget_numeric;
    @Column()
    private String budget_currency;
    @Column()
    private String budget_value_date;
    @Column()
    private String international_partners;
    @Column()
    private String local_partners;
    @Column()
    private String prime_awardee;
    @Column()
    private String target_project_reach;
    @Column()
    private String actual_project_reach;
    @Column()
    private String project_reach_unit;
    @Column()
    private String target_groups;
    @Column()
    private String geographic_scope;
    @Column(nullable = false)
    private String location;
    @Column()
    private String project_contact_person;
    @Column()
    private String project_contact_position;
    @Column()
    private String project_contact_email;
    @Column()
    private String project_contact_phone_number;
    @Column()
    private String project_website;
    @Column()
    private String date_provided;
    @Column()
    private String date_updated;
    @Column(nullable = false)
    private String status;
    @Column()
    private String donors;
    @Column(nullable = false)
    private String humanitarian;




}
