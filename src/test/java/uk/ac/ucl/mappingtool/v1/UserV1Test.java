package uk.ac.ucl.mappingtool.v1;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.ac.ucl.mappingtool.v1.repository.UserRepositoryV1;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserV1Test {

    @Autowired
    private UserRepositoryV1 userRepository;

    @Test
    public void testDb() throws Exception{
    }
}
