package uk.ac.ucl.mappingtool.v2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.map.country.Country;
import uk.ac.ucl.mappingtool.v2.domain.map.country.CountryDetail;
import uk.ac.ucl.mappingtool.v2.domain.result.ListView;

import java.lang.reflect.Type;
import java.util.List;

public class CountryTest {

    @Test
    public void testCountryInputOne(){
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



}
