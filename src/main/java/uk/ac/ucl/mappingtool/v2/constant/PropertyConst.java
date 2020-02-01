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

        ALL_FIELDS = Collections.unmodifiableSet(temp);
    }
}