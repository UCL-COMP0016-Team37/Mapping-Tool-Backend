package uk.ac.ucl.mappingtool.v2.service.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.abstractAttributes.coordinate.Coordinate;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.activity.ActivityQuery;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.activity.ActivityQueryItem;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.BudgetQuery;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.BudgetQueryItem;
import uk.ac.ucl.mappingtool.v2.domain.analysis.request.budget.RecipientCountry;
import uk.ac.ucl.mappingtool.v2.domain.country.Country;
import uk.ac.ucl.mappingtool.v2.domain.country.countryRes.ActivityDisplayItem;
import uk.ac.ucl.mappingtool.v2.domain.map.mainMap.FilteredPin;
import uk.ac.ucl.mappingtool.v2.domain.map.mainMap.ProjectPin;
import uk.ac.ucl.mappingtool.v2.domain.result.ListView;
import uk.ac.ucl.mappingtool.v2.repository.CountryRepository;
import uk.ac.ucl.mappingtool.v2.service.MapService;

import java.lang.reflect.Type;
import java.util.*;


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
    public List<FilteredPin> getFilterSectorPins(String sectorCode) {
        String url = "https://iatidatastore.iatistandard.org/api/budgets/aggregations/?group_by=recipient_country&aggregations=value,activity_count&format=json&sector=" + sectorCode;
        String json = HttpRequest.requestJson(url);

        Type queryType = new TypeToken<BudgetQuery<RecipientCountry>>(){} .getType();

        Gson gson = new Gson();
        BudgetQuery budgetQueryObject = gson.fromJson(json, queryType);

        // get list
        List<BudgetQueryItem<RecipientCountry>> results = budgetQueryObject.getResults();

        List<FilteredPin> pins = new ArrayList<>();

        for(BudgetQueryItem<RecipientCountry> item : results){
            String countryCode = item.getGroup().getCode();
            Optional<Country> optional = countryRepository.findById(countryCode);
            Country country = optional.get();

            String code = country.getCode();
            String name = country.getName();
            String longitude = country.getLongitude();
            String latitude = country.getLatitude();
            Coordinate coordinate = new Coordinate(longitude, latitude);
            Integer count = item.getActivity_count();
            Double value = item.getValue();

            FilteredPin pin = new FilteredPin(code, name, coordinate, count, value);
            pins.add(pin);
        }

        return pins;
    }

    @Override
    public List<FilteredPin> getFilterCountryPins(String country) {
        String url = "https://iatidatastore.iatistandard.org/api/activities/aggregations/?format=json&group_by=reporting_organisation&aggregations=count&recipient_country=" + country ;
        String json = HttpRequest.requestJson(url);
//        System.out.println(json);

        Type queryType = new TypeToken<ActivityQuery<String>>(){}.getType();

        Gson gson = new Gson();
        ActivityQuery budgetQueryObject = gson.fromJson(json, queryType);

        // get list
        List<ActivityQueryItem<String>> results = budgetQueryObject.getResults();
        // get total org count
        Integer totalOrgs = budgetQueryObject.getCount();

        return null;
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
