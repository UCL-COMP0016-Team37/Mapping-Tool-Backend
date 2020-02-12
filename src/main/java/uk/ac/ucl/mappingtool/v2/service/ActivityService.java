package uk.ac.ucl.mappingtool.v2.service;

import uk.ac.ucl.mappingtool.v2.domain.activity.Activity;

public interface ActivityService {
    public Activity getActivityById(String iatiId);
    public String getActivityByIdAndField(String iatiId, String field);
}
