package app.web.controller;

import app.data.UsersRepository;
import app.web.dto.Password;
import app.web.dto.UserRegistrationDetails;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Gabriel on 02.02.2017.
 */
public class UsersControllerTest {

    private UsersRepository usersRepository;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        usersRepository = mock(UsersRepository.class);
        UsersController usersController = new UsersController(usersRepository);
        mockMvc = standaloneSetup(usersController)
                .setViewResolvers(viewResolver())
                .build();
    }

    private ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Test
    public void showRegistrationForm() throws Exception {
        mockMvc.perform(get("/users/register"))
                .andExpect(model().attribute("details", new UserRegistrationDetails()))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void testProcessRegistration() throws Exception {
        UserRegistrationDetails details = makeUserRegistrationDetails();
        when(usersRepository.register(details)).thenReturn(details);
        mockMvc.perform(post("/users/register/")
                .param("username","michael1234")
                .param("password.password", "testPass")
                .param("password.confirmedPassword", "testPass")
                .param("firstName", "Michael")
                .param("lastName", "Jordan")
                .param("email", "michael@jordan.com"))
                .andExpect(redirectedUrl("/home"));
        verify(usersRepository, atLeastOnce()).register(details);
    }

    private UserRegistrationDetails makeUserRegistrationDetails() {
        Password password = new Password("testPass", "testPass");
        return new UserRegistrationDetails("michael1234", password,
                "Michael","Jordan", "michael@jordan.com");
    }

    @Test
    public void shouldFailValidationWithNoData() throws Exception {
        mockMvc.perform(post("/users/register/"))
                .andExpect(status().isOk())
                .andExpect(view().name("registerForm"))
                .andExpect(model().errorCount(5))
                .andExpect(model().attributeHasFieldErrors(
                        "details", "username", "password", "firstName", "lastName", "email"));
    }

    @Test
    public void showUserProfile() throws Exception {
        UserRegistrationDetails details = makeUserRegistrationDetails();
        when(usersRepository.findByUsername("michael1234")).thenReturn(details);
        mockMvc.perform(get("/users/michael1234"))
                .andExpect(model().attribute("details", details))
                .andExpect(view().name("profile"));
    }

    @Test
    public void testShowLoginPage() throws Exception {
        mockMvc.perform(get("/users/login"))
                .andExpect(view().name("login"));
    }
}
