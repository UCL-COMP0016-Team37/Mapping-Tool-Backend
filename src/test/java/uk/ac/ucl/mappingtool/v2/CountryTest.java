package uk.ac.ucl.mappingtool.v2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.map.country.Country;
import uk.ac.ucl.mappingtool.v2.domain.map.country.countryDetail.CountryDetail;
import uk.ac.ucl.mappingtool.v2.domain.result.ListView;

import java.lang.reflect.Type;
import java.util.List;

public class CountryTest {

    @Test
    public void testCountryOne(){
        String countryUrl = "https://iatidatastore.iatistandard.org/api/countries/?format=json";
        String json = HttpRequest.requestJson(countryUrl);
        Type countryType = new TypeToken<ListView<Country>>(){}.getType();

        Gson gson = new Gson();
        ListView<Country> countryList = gson.fromJson(json, countryType);

        List<Country> countries = countryList.getResults();

        System.out.println(countries.toString());
    }

    @Test
    public void testCountryDetailOne(){
        String countryDetailUrl = "https://iatidatastore.iatistandard.org/api/countries/AE/?format=json";
        String json = HttpRequest.requestJson(countryDetailUrl);
        Type detailType = new TypeToken<CountryDetail>(){}.getType();

        Gson gson = new Gson();
        CountryDetail countryDetail = gson.fromJson(json, detailType);

        System.out.println(countryDetail);
    }

    @Test
    public void testCountryDatabaseOne(){
        String countryUrl = "https://iatidatastore.iatistandard.org/api/countries/?format=json";
        String json = HttpRequest.requestJson(countryUrl);
        Type countryType = new TypeToken<ListView<Country>>(){}.getType();

        Gson gson = new Gson();
        ListView<Country> countryList = gson.fromJson(json, countryType);

        List<Country> countries = countryList.getResults();

        // for one country
        Country country = countries.get(2);
        String countryDetailUrl = country.getUrl();
        json = HttpRequest.requestJson(HttpRequest.changeToHttps(countryDetailUrl));
        CountryDetail countryDetail = gson.fromJson(json, CountryDetail.class);

        // get longitude and latitude
        Double longitude = countryDetail.getLocation().getCoordinates().get(0);
        Double latitude = countryDetail.getLocation().getCoordinates().get(1);

        // set longitude and latitude
        country.setLongitude(longitude.toString());
        country.setLatitude(latitude.toString());

        System.out.println(country);
    }



}
