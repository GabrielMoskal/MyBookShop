package app.web.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gabriel on 01.05.2017.
 */
public class UserRegistrationTest {

    private UserRegistration user;

    @Before
    public void setUp() {
        Password passwordObj = new Password("password", "password");
        user = new UserRegistration("username", passwordObj,
                "firstname", "lastname", "email");
    }

    @Test
    public void constructorCorrect() {
        assertEquals("username", user.getUsername());
        assertEquals("password", user.getPassword().toString());
        assertEquals("firstname", user.getFirstName());
        assertEquals("lastname", user.getLastName());
        assertEquals("email", user.getEmail());
    }
}
