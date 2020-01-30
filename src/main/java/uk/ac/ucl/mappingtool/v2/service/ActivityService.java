package uk.ac.ucl.mappingtool.v2.service;

import uk.ac.ucl.mappingtool.v2.domain.Activity;

public interface ActivityService {
    public Activity getActivityById(String iatiId);
}
