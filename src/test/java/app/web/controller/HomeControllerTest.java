package app.web.controller;

import app.web.controller.HomeController;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Gabriel on 02.02.2017.
 */
@Ignore
public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        /*
        HomeController controller = context.getBean(HomeController.class)l
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
        mockMvc.perform(get("/home/")).andExpect(view().name("home"));
        */
    }
}