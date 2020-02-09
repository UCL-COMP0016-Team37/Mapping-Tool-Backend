package uk.ac.ucl.mappingtool.v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.ac.ucl.mappingtool.v2.constant.PropertyConst;
import uk.ac.ucl.mappingtool.v2.domain.map.country.Country;
import uk.ac.ucl.mappingtool.v2.service.CountryService;

import java.util.List;

@RestController
@RequestMapping(value = PropertyConst.root + "/Country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/")
    public List<Country> getAllCountries() {
        return countryService.getAll();
    }


    @GetMapping("/{id}")
    public Country getSingleCountry(@PathVariable("id") String id){
        return countryService.getOne(id);
    }

    @PostMapping("/remote")
    public void updateCountries(){
        countryService.insertAll();
    }

}
