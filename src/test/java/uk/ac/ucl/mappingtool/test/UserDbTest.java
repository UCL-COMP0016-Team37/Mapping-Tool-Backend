package uk.ac.ucl.mappingtool.test;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import uk.ac.ucl.mappingtool.MappingToolApplication;
import uk.ac.ucl.mappingtool.test.domain.User;
import uk.ac.ucl.mappingtool.test.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MappingToolApplication.class)
public class UserDbTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception{
    }
}
