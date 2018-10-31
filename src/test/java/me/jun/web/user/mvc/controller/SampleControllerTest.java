package me.jun.web.user.mvc.controller;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import me.jun.web.mvc.controller.SampleController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebClient webClient;

    @Test
    public void helloTest(){
        try {
            mockMvc.perform(get("/helloworld"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("jun")))
                    .andExpect(view().name("hello"))
                    .andExpect(model().attribute("name","jun"))
                  //  .andExpect(xpath("//h1").string("jun"))
                    .andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Test
    public  void helloHtml() throws IOException {
        HtmlPage page = webClient.getPage("/helloworld");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1");
        assertThat(h1.getTextContent()).isEqualToIgnoringCase("jun");



    }
}
