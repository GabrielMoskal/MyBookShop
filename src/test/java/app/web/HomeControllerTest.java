package app.web;

import app.web.controller.HomeController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Gabriel on 02.02.2017.
 */
public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        /*
        HomeController controller = new HomeController(null);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
        mockMvc.perform(get("/home/")).andExpect(view().name("home"));
        */
    }
}
