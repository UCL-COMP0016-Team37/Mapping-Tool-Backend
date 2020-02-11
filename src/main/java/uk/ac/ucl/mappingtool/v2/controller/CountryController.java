package uk.ac.ucl.mappingtool.v2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.ac.ucl.mappingtool.v2.constant.PropertyConst;
import uk.ac.ucl.mappingtool.v2.domain.country.Country;
import uk.ac.ucl.mappingtool.v2.service.CountryService;

import java.util.List;

@RestController
@Api(value = "Country Controller", tags = {"Country Controller"})
@RequestMapping(value = PropertyConst.root + "/Country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/")
    @ApiOperation(value = "Get the list of all available countries currently in the database")
    public List<Country> getAllCountries() {
        return countryService.getAll();
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Obtain the information of one country")
    public Country getSingleCountry(@PathVariable("id") String id){
        return countryService.getOne(id);
    }

    @PostMapping("/remote")
    @ApiOperation(
            value = "Obtain the current country data from iati.cloud and update the database",
            notes = "DANGEROUS, It will acturally modify the database; It will also takes a long time to finish it"
    )
    public void updateCountries(){
        countryService.insertAll();
    }

}
