package uk.ac.ucl.mappingtool.v2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.mappingtool.v2.constant.PropertyConst;
import uk.ac.ucl.mappingtool.v2.domain.map.mainMap.ProjectPin;
import uk.ac.ucl.mappingtool.v2.service.MapService;

import java.util.List;

@RestController
@RequestMapping(value = PropertyConst.root + "/maps")
public class MapController {

    private static final String PIN = "/pin";

    @Autowired
    private MapService mapService;

    @GetMapping(PIN + "/")
    public List<ProjectPin> getAllPins(){
        return mapService.getAllPins();
    }

    @GetMapping(PIN + "/{code}")
    public ProjectPin getOnePin(@PathVariable("code") String code ){
        return mapService.getOnePin(code);
    }
}
