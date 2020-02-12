package uk.ac.ucl.mappingtool.v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.ucl.mappingtool.v2.domain.publisher.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, String> {
}
