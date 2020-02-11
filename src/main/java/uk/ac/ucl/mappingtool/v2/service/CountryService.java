package uk.ac.ucl.mappingtool.v2.service;

import uk.ac.ucl.mappingtool.v2.domain.country.Country;

import java.util.List;

public interface CountryService {
    public List<Country> getAll();
    public Country getOne(String id);
    public void insertAll();

}
