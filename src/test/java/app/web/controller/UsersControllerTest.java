package app.web.controller;

import app.data.UsersRepository;
import app.web.dto.Password;
import app.web.dto.UserRegistrationDetails;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Gabriel on 02.02.2017.
 */
@Ignore
public class UsersControllerTest {
    /*
    @Test
    public void testRegisterForm() throws Exception {
        UsersRepository userRepository = mock(UsersRepository.class);
        UsersController usersController = new UsersController(userRepository);
        MockMvc mockMvc = standaloneSetup(usersController).build();
        mockMvc.perform(get("/users/register"))
                .andExpect(view().name("registerForm"));
    }


    @Test
    public void testProcessRegistration() throws Exception {
        UsersRepository usersRepository = mock(UsersRepository.class);
        Password password = new Password("testPass", "testPass");
        UserRegistrationDetails unsaved = new UserRegistrationDetails("michael1234", password,
                "Michael","Jordan", "michael@jordan.com");
        UserRegistrationDetails saved = new UserRegistrationDetails("michael1234", password,
                "Michael","Jordan", "michael@jordan.com");
        when(usersRepository.register(unsaved)).thenReturn(saved);

        UsersController usersController = new UsersController(usersRepository);
        MockMvc mockMvc = standaloneSetup(usersController).build();
        mockMvc.perform(post("/users/register")
                .param("username","michael1234")
                .param("password", "testPass")
                .param("confirmedPassword", "testPass")
                .param("firstName", "Michael")
                .param("lastName", "Jordan")
                .param("email", "michael@jordan.com"))
                .andExpect(redirectedUrl("/home"));
        verify(usersRepository, atLeastOnce()).register(unsaved);
    }

    // TODO
    @Test
    public void shouldFailValidationWithNoData() throws Exception {

        UsersRepository usersRepository = mock(UsersRepository.class);
        UsersController controller = new UsersController(usersRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/users/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("registerForm"))
                .andExpect(model().errorCount(6))
                .andExpect(model().attributeHasFieldErrors(
                        "user", "firstName", "lastName", "username", "password", "confirmedPassword", "email"));

    }

    @Test
    public void testShowUserProfile() throws Exception {
        UsersRepository usersRepository = mock(UsersRepository.class);
        Password password = new Password("testPass", "testPass");
        UserRegistrationDetails saved = new UserRegistrationDetails("michael1234", password,
                "Michael","Jordan", "michael@jordan.com");
        when(usersRepository.findByUsername("michael1234")).thenReturn(saved);

        UsersController usersController = new UsersController(usersRepository);
        MockMvc mockMvc = standaloneSetup(usersController).build();

        mockMvc.perform(get("/users/michael1234"))
                .andExpect(view().name("profile"));
    }
    */
}
