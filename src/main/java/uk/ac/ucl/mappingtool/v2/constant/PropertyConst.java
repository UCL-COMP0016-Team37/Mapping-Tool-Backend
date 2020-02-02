package uk.ac.ucl.mappingtool.v2.constant;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PropertyConst {
    public static final String root = "/api/v2";

    public static final Set<String> ALL_FIELDS;   // ignorance for attributes

    static{
        Set<String> temp = new HashSet<String>();
        temp.add("recipient_countries");
        temp.add("recipient_regions");
        temp.add("sectors");
        temp.add("humanitarian");
        temp.add("hierarchy");
        temp.add("activity_status");
        temp.add("activity_scope");
        temp.add("reporting_org");
        temp.add("title");
        temp.add("descriptions");
        temp.add("participating_organisations");
        temp.add("other_identifier");
        temp.add("activity_dates");
        temp.add("contact_info");
        temp.add("locations");
        temp.add("default_aid_type");
        temp.add("transactions");
        temp.add("document_links");
        temp.add("related_activities");

        ALL_FIELDS = Collections.unmodifiableSet(temp);
    }
}