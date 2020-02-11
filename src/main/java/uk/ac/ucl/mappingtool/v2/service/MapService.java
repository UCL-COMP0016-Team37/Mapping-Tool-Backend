package uk.ac.ucl.mappingtool.v2.service;

import uk.ac.ucl.mappingtool.v2.domain.map.mainMap.ProjectPin;

import java.util.List;

public interface MapService {
    public ProjectPin getOnePin(String code);
    public List<ProjectPin> getAllPins();
}
