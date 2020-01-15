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

    @Id()
    @ApiModelProperty("Project Unique ID")
    private String interaction_intervention_id;

    @Column(nullable = false)
    private String organization;
    @Column(name = "org_intervention_id")
    private String orgInterventionId;
    @Column(name = "project_tags")
    private String projectTags;
    @Column(nullable = false, name = "project_name")
    private String projectName;
    @Column(name = "project_description")
    private String projectDescription;
    @Column(name = "activities")
    private String activities;
    @Column(name = "additional_information")
    private String additionalInformation;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "sectors")
    private String sectors;
    @Column(name = "cross_cutting_issues")
    private String crossCuttingIssues;
    @Column(name = "budget_numeric")
    private String budgetNumeric;
    @Column(name = "budget_currency")
    private String budgetCurrency;
    @Column(name = "budget_value_date")
    private String budgetValueDate;
    @Column(name = "international_partners")
    private String internationalPartners;
    @Column(name = "local_partners")
    private String localPartners;
    @Column(name = "prime_awardee")
    private String primeAwardee;
    @Column(name = "target_project")
    private String targetProjectReach;
    @Column(name = "actual_project_reach")
    private String actualProjectReach;
    @Column(name = "project_reach_unit")
    private String projectReachUnit;
    @Column(name = "target_groups")
    private String targetGroups;
    @Column(name = "geographicScope")
    private String geographic_scope;
    @Column(nullable = false, name = "location")
    private String location;
    @Column(name = "project_contact_person")
    private String projectContactPerson;
    @Column(name = "project_contact_position")
    private String projectContactPosition;
    @Column(name = "project_contact_email")
    private String projectContactEmail;
    @Column(name = "project_contact_phone_number")
    private String projectContactPhoneNumber;
    @Column(name = "project_website")
    private String projectWebsite;
    @Column(name = "date_provided")
    private String dateProvided;
    @Column(name = "date_updated")
    private String dateUpdated;
    @Column(nullable = false)
    private String status;
    @Column(name = "donors")
    private String donors;
    @Column(nullable = false, name = "humanitarian")
    private String humanitarian;




}
