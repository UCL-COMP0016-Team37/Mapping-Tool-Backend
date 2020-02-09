package uk.ac.ucl.mappingtool.v2.service.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import uk.ac.ucl.mappingtool.util.HttpRequest;
import uk.ac.ucl.mappingtool.v2.domain.map.country.Country;
import uk.ac.ucl.mappingtool.v2.domain.map.country.countryDetail.CountryDetail;
import uk.ac.ucl.mappingtool.v2.domain.result.ListView;
import uk.ac.ucl.mappingtool.v2.repository.CountryRepository;
import uk.ac.ucl.mappingtool.v2.service.CountryService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getOne(String id) {
        Optional<Country> optional = countryRepository.findById(id);
        Country country = optional.get();
        return country;
    }

    @Override
    public void insertAll() {
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
                }catch (HttpServerErrorException hsee){
                    continue;
                }

            }

            totalCountries.addAll(nextCountries);
        }

        // insert into database
        for(Country country: totalCountries){
            countryRepository.save(country);
        }
    }


    /**
     * Help function for InsertAll from iati api
     * @param country
     */
    private void getCountryDetails(Country country) {

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
}
