package uk.ac.ucl.mappingtool.v1.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@ApiModel(description = "Project Model")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projects")
public class Project {

    @Id
    @ApiModelProperty("Project Unique ID")
    private String interaction_intervention_id;

    private String organization;
    private String org_intervention_id;
    private String project_tags;
    private String project_name;
    private String project_description;
    private String activities;
    private String additional_information;
    private String start_date;
    private String end_date;
    private String sectors;
    private String cross_cutting_issues;
    private String budget_numeric;
    private String budget_currency;
    private String budget_value_date;
    private String international_partners;
    private String local_partners;
    private String prime_awardee;
    private String target_project_reach;
    private String actual_project_reach;
    private String project_reach_unit;
    private String target_groups;
    private String geographic_scope;
    private String location;
    private String project_contact_person;
    private String project_contact_position;
    private String project_contact_email;
    private String project_contact_phone_number;
    private String project_website;
    private String date_provided;
    private String date_updated;
    private String status;
    private String donors;
    private String humanitarian;




}
