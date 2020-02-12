package uk.ac.ucl.mappingtool.v2.service.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.coordinate.Coordinate;
import uk.ac.ucl.mappingtool.v2.domain.country.Country;
import uk.ac.ucl.mappingtool.v2.domain.country.countryRes.ActivityDisplayItem;
import uk.ac.ucl.mappingtool.v2.domain.map.mainMap.ProjectPin;
import uk.ac.ucl.mappingtool.v2.domain.result.ListView;
import uk.ac.ucl.mappingtool.v2.repository.CountryRepository;
import uk.ac.ucl.mappingtool.v2.service.MapService;

import java.lang.reflect.Type;
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

    @Override
    public List<ActivityDisplayItem> getPartPins(String code, int page) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://iatidatastore.iatistandard.org/api/activities/?"); // base url
        sb.append("format=json&");  // format
        sb.append("fields=title&"); // fields

        sb.append("recipient_country=");
        sb.append(code);
        sb.append("&");
        sb.append("page=");
        sb.append(page);

        String url = sb.toString();

        String json = HttpRequest.requestJson(url);
        Type countryType = new TypeToken<ListView<ActivityDisplayItem>>(){}.getType();

        Gson gson = new Gson();
        ListView<ActivityDisplayItem> countryListView = gson.fromJson(json, countryType);

        return countryListView.getResults();
    }

    private ProjectPin createPinObject(Country country){
        String code = country.getCode();
        String name = country.getName();
        String longitude = country.getLongitude();
        String latitude = country.getLatitude();
        Coordinate coordinate = new Coordinate(longitude, latitude);
        Integer count = country.getCount();

        ProjectPin pin = new ProjectPin(code, name, coordinate, count);

        return pin;
    }


}
