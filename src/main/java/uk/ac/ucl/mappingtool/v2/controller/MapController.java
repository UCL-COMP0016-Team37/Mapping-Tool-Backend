package uk.ac.ucl.mappingtool.v2.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.ucl.mappingtool.v2.constant.PropertyConst;
import uk.ac.ucl.mappingtool.v2.domain.country.countryRes.ActivityDisplayItem;
import uk.ac.ucl.mappingtool.v2.domain.map.flowMap.CountryFlow;
import uk.ac.ucl.mappingtool.v2.domain.map.mainMap.FilteredPin;
import uk.ac.ucl.mappingtool.v2.domain.map.mainMap.ProjectPin;
import uk.ac.ucl.mappingtool.v2.service.MapService;

import java.util.List;

@RestController
@Api(value = "Map Controller", tags = {"Map Controller"})
@RequestMapping(value = PropertyConst.root + "/maps")
public class MapController {

    private static final String PIN = "/pin";

    @Autowired
    private MapService mapService;

    @GetMapping(PIN + "/")
    @ApiOperation(
            value = "Get the list of all available project Pins on the main map",
            tags = {"Pin Map Controller"}
            )
    public List<ProjectPin> getAllPins(){
        return mapService.getAllPins();
    }

    @GetMapping(PIN + "/{code}")
    @ApiOperation(
            value = "Obtain the information of one project pin",
            tags = {"Pin Map Controller"}
            )
    public ProjectPin getOnePin(@PathVariable("code") String code ){
        return mapService.getOnePin(code);
    }


    @GetMapping(PIN + "/{code}/{page}")
    @ApiOperation(
            value = "Obtain the result list on a pin, and show the list with a size of 10",
            tags = {"Pin Map Controller"}
            )
    public List<ActivityDisplayItem> getDetailPins(@PathVariable("code") String code, @PathVariable("page") Integer page){
        return mapService.getPartPins(code, page);
    }

    @GetMapping(PIN + "/filter/sector/{sector-code}")
    @ApiOperation(value = "Obtain the filtered sector result on the map", tags = {"Analysis Controller", "Heap Map Controller"})
    public List<FilteredPin> getFilterSectorPins(@PathVariable("sector-code") String code){
        return mapService.getFilterSectorPins(code);
    }

    @GetMapping(PIN + "/filter/country/{country-code}")
    @ApiOperation(value = "Obtain the filtered country result on the map", tags = {"Analysis Controller", "Flow Map Controller"})
    public CountryFlow getFilterCountryFlow(@PathVariable("country-code") String code){
        return mapService.getFilterCountryFlow(code);
    }


}
