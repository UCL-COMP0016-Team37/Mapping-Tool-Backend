package uk.ac.ucl.mappingtool.v2.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.coordinate.Coordinate;
import uk.ac.ucl.mappingtool.v2.domain.country.Country;
import uk.ac.ucl.mappingtool.v2.domain.map.mainMap.ProjectPin;
import uk.ac.ucl.mappingtool.v2.repository.CountryRepository;
import uk.ac.ucl.mappingtool.v2.service.MapService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MapServiceImpl implements MapService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public ProjectPin getOnePin(String code) {
        Optional<Country> optional = countryRepository.findById(code);
        Country country = optional.get();

        return createPinObject(country);
    }

    @Override
    public List<ProjectPin> getAllPins() {
        List<Country> countries = countryRepository.findAll();
        List<ProjectPin> pinList = new ArrayList<>();

        for(Country country : countries){
            ProjectPin pin = createPinObject(country);
            pinList.add(pin);
        }

        return pinList;
    }

    private ProjectPin createPinObject(Country country){
        String code = country.getCode();
        String longitude = country.getLongitude();
        String latitude = country.getLatitude();
        Coordinate coordinate = new Coordinate(longitude, latitude);
        Integer count = country.getCount();

        ProjectPin pin = new ProjectPin(code, coordinate, count);

        return pin;
    }
}
