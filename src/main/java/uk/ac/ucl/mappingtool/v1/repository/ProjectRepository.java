package uk.ac.ucl.mappingtool.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.ac.ucl.mappingtool.v1.domain.Project;


/**
 * This is for accessing the existing Project database
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

}
