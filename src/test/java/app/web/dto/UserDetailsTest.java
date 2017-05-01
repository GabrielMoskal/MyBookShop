package app.web.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gabriel on 01.05.2017.
 */
public class UserDetailsTest {
    @Test
    public void constructorCorrect() {
        UserDetails userDetails = new UserDetails("username", "firstName", "lastName", "email");
        assertEquals("username", userDetails.getUsername());
        assertEquals("firstName", userDetails.getFirstName());
        assertEquals("lastName", userDetails.getLastName());
        assertEquals("email", userDetails.getEmail());
    }
}
