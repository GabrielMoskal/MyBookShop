package app.web;

import app.User;
import app.data.UsersRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Gabriel on 02.02.2017.
 */
public class UsersControllerTest {

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
        User unsaved = new User("michael1234", "testPass", "testPass", "Michael","Jordan");
        User saved = new User(55L,"michael1234", "testPass", "testPass", "Michael","Jordan");
        when(usersRepository.save(unsaved)).thenReturn(saved);

        UsersController usersController = new UsersController(usersRepository);
        MockMvc mockMvc = standaloneSetup(usersController).build();
        mockMvc.perform(post("/users/register")
                .param("username","michael1234")
                .param("password", "testPass")
                .param("confirmedPassword", "testPass")
                .param("firstName", "Michael")
                .param("lastName", "Jordan"))
                .andExpect(redirectedUrl("/users/michael1234"));
        verify(usersRepository, atLeastOnce()).save(unsaved);
    }

    @Test
    public void shouldFailValidationWithNoData() throws Exception {
        UsersRepository usersRepository = mock(UsersRepository.class);
        UsersController controller = new UsersController(usersRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/users/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("registerForm"))
                .andExpect(model().errorCount(5))
                .andExpect(model().attributeHasFieldErrors(
                        "user", "firstName", "lastName", "username", "password", "confirmedPassword"));
    }

    @Test
    public void testShowUserProfile() throws Exception {
        UsersRepository usersRepository = mock(UsersRepository.class);
        User saved = new User(55L,"michael1234", "testPass", "testPass", "Michael","Jordan");
        when(usersRepository.findByUsername("michael1234")).thenReturn(saved);

        UsersController usersController = new UsersController(usersRepository);
        MockMvc mockMvc = standaloneSetup(usersController).build();

        mockMvc.perform(get("/users/michael1234"))
                .andExpect(view().name("profile"));
    }
}
