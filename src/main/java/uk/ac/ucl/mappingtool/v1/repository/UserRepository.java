package uk.ac.ucl.mappingtool.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uk.ac.ucl.mappingtool.v1.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //
    @Query(value = "update user set name=?1 where id=?4",nativeQuery = true)   //place holder
    @Modifying
    int updateById(String name,int id);

    @Query("from User u where u.username=:username")   //SPEL expression
    User findUser(@Param("username") String username);// Param username, map username in db
}