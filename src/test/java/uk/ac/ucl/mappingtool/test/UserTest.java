package uk.ac.ucl.mappingtool.test;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.ac.ucl.mappingtool.test.constant.PropertyConst;
import uk.ac.ucl.mappingtool.test.controller.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    private MockMvc mvc;
    private RequestBuilder request;

    private static final String userRoot = PropertyConst.root + "/users";

    @Before
    public void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserGet() throws Exception{
        // test basic RequestBuilder
        request = get(userRoot + "/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }


    @Test
    public void testUserController() throws Exception {
        // Test UserController
        // get empty list
        request = get(userRoot + "/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        // post a user
        request = post(userRoot + "/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"yangtao\",\"age\":20}");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // get new user list
        request = get(userRoot + "/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"yangtao\",\"age\":20}]")));

        // put to user id = 1
        request = put(userRoot + "/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"terry\",\"age\":21}");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // get to check user id = 1
        request = get(userRoot + "/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"terry\",\"age\":21}")));

        // delete user id = 1
        request = delete(userRoot + "/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // check new user list
        request = get(userRoot + "/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }
}
