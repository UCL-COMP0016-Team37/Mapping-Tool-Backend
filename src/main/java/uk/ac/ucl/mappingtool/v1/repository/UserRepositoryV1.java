package uk.ac.ucl.mappingtool.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uk.ac.ucl.mappingtool.v1.domain.UserV1;

@Repository
public interface UserRepositoryV1 extends JpaRepository<UserV1, Integer> {

    //
    @Query(value = "update user set name=?1 where id=?4",nativeQuery = true)   //place holder
    @Modifying
    int updateById(String name,int id);

    @Query("from UserV1 u where u.username=:username")   //SPEL expression
    UserV1 findUser(@Param("username") String username);// Param username, map username in db
}