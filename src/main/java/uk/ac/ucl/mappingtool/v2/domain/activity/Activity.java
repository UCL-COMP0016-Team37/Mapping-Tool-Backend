package uk.ac.ucl.mappingtool.v2.domain.activity;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.ac.ucl.mappingtool.v2.domain.activity.activityDate.ActivityDate;
import uk.ac.ucl.mappingtool.v2.domain.activity.activityScope.ActivityScope;
import uk.ac.ucl.mappingtool.v2.domain.activity.activityStatus.ActivityStatus;
import uk.ac.ucl.mappingtool.v2.domain.activity.budget.Budget;
import uk.ac.ucl.mappingtool.v2.domain.activity.contactInfo.ContactInfo;
import uk.ac.ucl.mappingtool.v2.domain.activity.defaultAidType.DefaultAidType;
import uk.ac.ucl.mappingtool.v2.domain.activity.description.Description;
import uk.ac.ucl.mappingtool.v2.domain.activity.documentLink.DocLink;
import uk.ac.ucl.mappingtool.v2.domain.activity.location.Location;
import uk.ac.ucl.mappingtool.v2.domain.activity.otherIdentifier.OtherIdentifier;
import uk.ac.ucl.mappingtool.v2.domain.activity.participatingOrg.ParticipatingOrg;
import uk.ac.ucl.mappingtool.v2.domain.activity.recipientCountry.RecipientCountry;
import uk.ac.ucl.mappingtool.v2.domain.activity.recipientRegion.RecipientRegion;
import uk.ac.ucl.mappingtool.v2.domain.activity.activitySector.ActivitySector;
import uk.ac.ucl.mappingtool.v2.domain.activity.relatedActivity.RelatedActivity;
import uk.ac.ucl.mappingtool.v2.domain.activity.reportingOrg.ReportingOrg;
import uk.ac.ucl.mappingtool.v2.domain.activity.title.Title;

import java.util.List;


/**
 * Default activity POJO
 * N.B. Must add @JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY) to possible null entities
 * Non successful mapping entities will be automatically set as theirs default value
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

    // default entries
    private String iati_identifier;
    private List<RecipientCountry> recipient_countries;
    @JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY)
    private List<RecipientRegion> recipient_regions;
    @JsonSerialize(include= JsonSerialize.Inclusion.NON_EMPTY)
    private List<ActivitySector> sectors;

    // additional entries
    private Boolean humanitarian;
    private Integer hierarchy;
    private ActivityStatus activity_status;
    private ActivityScope activity_scope;
    private ReportingOrg reporting_org;
    private Title title;
    private List<Description> descriptions;
    private List<ParticipatingOrg> participating_organisations;
    private List<OtherIdentifier> other_identifier;
    private List<ActivityDate> activity_dates;
    private List<ContactInfo> contact_info;
    private List<Location> locations;
    private List<DefaultAidType> default_aid_type;
    private String transactions;  // url temp
    private List<DocLink> document_links;
    private List<RelatedActivity> related_activities;
    private List<Budget> budgets;



}
