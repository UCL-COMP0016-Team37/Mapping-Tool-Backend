package uk.ac.ucl.mappingtool.v2.service;

import uk.ac.ucl.mappingtool.v1.domain.Project;
import uk.ac.ucl.mappingtool.v2.domain.country.countryRes.ActivityDisplayItem;
import uk.ac.ucl.mappingtool.v2.domain.map.mainMap.FilteredPin;
import uk.ac.ucl.mappingtool.v2.domain.map.mainMap.ProjectPin;

import java.util.List;

public interface MapService {
    public ProjectPin getOnePin(String code);
    public List<ProjectPin> getAllPins();
    public List<ActivityDisplayItem> getPartPins(String code, int page);
    public List<FilteredPin> getFilterSectorPins(String sector); // country
    public List<FilteredPin> getFilterCountryPins(String country);  // organizations with transaction
}
