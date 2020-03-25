package uk.ac.ucl.mappingtool.v2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.springframework.web.client.HttpServerErrorException;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.activity.Activity;
import uk.ac.ucl.mappingtool.v2.domain.country.Country;
import uk.ac.ucl.mappingtool.v2.domain.country.countryRes.ActivityNumItem;
import uk.ac.ucl.mappingtool.v2.domain.country.countryDetail.CountryDetail;
import uk.ac.ucl.mappingtool.v2.domain.result.ListView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CountryTest {

//    @Test
    public void testCountryOne() {
        String countryUrl = "https://iatidatastore.iatistandard.org/api/countries/?format=json";
        String json = HttpRequest.requestJson(countryUrl);
        Type countryType = new TypeToken<ListView<Country>>() {
        }.getType();

        Gson gson = new Gson();
        ListView<Country> countryList = gson.fromJson(json, countryType);

        List<Country> countries = countryList.getResults();

        System.out.println(countries.toString());
    }

//    @Test
    public void testCountryDetailOne() {
        String countryDetailUrl = "https://iatidatastore.iatistandard.org/api/countries/AE/?format=json";
        String json = HttpRequest.requestJson(countryDetailUrl);
        Type detailType = new TypeToken<CountryDetail>() {
        }.getType();

        Gson gson = new Gson();
        CountryDetail countryDetail = gson.fromJson(json, detailType);

        System.out.println(countryDetail);
    }

//    @Test
    public void testCountryDatabaseOne() {
        String countryUrl = "https://iatidatastore.iatistandard.org/api/countries/?format=json";
        String json = HttpRequest.requestJson(countryUrl);
        Type countryType = new TypeToken<ListView<Country>>() {
        }.getType();

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

//    @Test
    public void testCountriesOnePage() {
        String countryUrl = "https://iatidatastore.iatistandard.org/api/countries/?format=json";
        String json = HttpRequest.requestJson(countryUrl);
        Type countryType = new TypeToken<ListView<Country>>() {
        }.getType();

        Gson gson = new Gson();
        ListView<Country> countryList = gson.fromJson(json, countryType);

        List<Country> countries = countryList.getResults();

        /* each country */
        for (Country country : countries) {
//            String countryDetailUrl = country.getUrl();
//            json = HttpRequest.requestJson(HttpRequest.changeToHttps(countryDetailUrl));
//            CountryDetail countryDetail = gson.fromJson(json, CountryDetail.class);
//
//            // get longitude and latitude
//            Double longitude = countryDetail.getLocation().getCoordinates().get(0);
//            Double latitude = countryDetail.getLocation().getCoordinates().get(1);
//
//            // set longitude and latitude
//            country.setLongitude(longitude.toString());
//            country.setLatitude(latitude.toString());
            getCountryDetails(country);
            getCountryTotalActivities(country);
        }

        System.out.println(countries.toString());
    }


//    @Test
    public void testCountriesMultiPages() {
        String countryUrl = "https://iatidatastore.iatistandard.org/api/countries/?format=json";
        String json = HttpRequest.requestJson(countryUrl);
        Type countryType = new TypeToken<ListView<Country>>() {
        }.getType();

        Gson gson = new Gson();
        ListView<Country> countryListView = gson.fromJson(json, countryType);

        List<Country> totalCountries = new ArrayList<>();
        List<Country> countries = countryListView.getResults();
        for (Country country : countries) {
            getCountryDetails(country);
        }

        totalCountries.addAll(countries);


        // get count
        int count = countryListView.getCount();
        int totalPage = count / 10 + 1;

        for (int i = 2; i <= totalPage; i++) {
            String nextUrl = "https://iatidatastore.iatistandard.org/api/countries/?format=json&page=" + i;
            String nextJson = HttpRequest.requestJson(nextUrl);
            ListView<Country> nextCountryListView = gson.fromJson(nextJson, countryType);

            List<Country> nextCountries = nextCountryListView.getResults();
            for (Country country : nextCountries) {
                try {
                    getCountryDetails(country);
                    getCountryTotalActivities(country);
                }catch (HttpServerErrorException hsee){
                    continue;
                }

            }

            totalCountries.addAll(nextCountries);
        }

        System.out.println(totalCountries);
    }


    private void getCountryDetails(Country country) throws HttpServerErrorException{

        /* each country */
        String countryDetailUrl = country.getUrl();
        String json = HttpRequest.requestJson(HttpRequest.changeToHttps(countryDetailUrl));

        Gson gson = new Gson();
        CountryDetail countryDetail = gson.fromJson(json, CountryDetail.class);

        // get longitude and latitude
        Double longitude = countryDetail.getLocation().getCoordinates().get(0);
        Double latitude = countryDetail.getLocation().getCoordinates().get(1);

        // set longitude and latitude
        country.setLongitude(longitude.toString());
        country.setLatitude(latitude.toString());

    }

    private void getCountryTotalActivities(Country country) throws HttpServerErrorException{
        String countryCode = country.getCode();
        String url = "https://iatidatastore.iatistandard.org/api/activities/?format=json&recipient_country=" + countryCode;
        String json = HttpRequest.requestJson(url);

        Gson gson = new Gson();
        Type countryActivityType = new TypeToken<ListView<ActivityNumItem>>() {}.getType();
        ListView<Activity> countryActivityListView = gson.fromJson(json, countryActivityType);

        //System.out.println(countryActivityListView.getResults());
        //System.out.println(countryActivityListView.getCount());

        int count = countryActivityListView.getCount();
        country.setCount(count);
    }


}
