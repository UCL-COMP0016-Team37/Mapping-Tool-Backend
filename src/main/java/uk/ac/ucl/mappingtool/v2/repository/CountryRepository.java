package uk.ac.ucl.mappingtool.v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.ucl.mappingtool.v2.domain.country.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}
