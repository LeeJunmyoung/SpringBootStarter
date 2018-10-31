package me.jun.web.user.hateoas;

import me.jun.web.hateoas.HateoasTestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HateoasTestController.class)
public class HateoasTestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hateoasTest() throws Exception {
        mockMvc.perform(get("/hateoas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._links.self").exists());


    }

}
