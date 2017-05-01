package app.web.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gabriel on 01.05.2017.
 */
public class PasswordTest {

    private Password password;

    @Before
    public void setUp() {
        password = new Password("testValue", "testValue");
    }

    @Test
    public void constructorCorrect() {
        assertEquals("testValue", password.getPassword());
        assertEquals("testValue", password.getConfirmedPassword());
    }

    @Test
    public void charAtCorrect() {
        assertEquals('t', password.charAt(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void expectedExceptionAtInvalidIndex() {
        password.charAt(-1);
    }

    @Test
    public void lengthCorrect() {
        int expected = password.getPassword().length();
        assertEquals(expected, password.length());
    }

    @Test
    public void subSequenceCorrect() {
        int start = 0, end = 4;
        CharSequence expected = password.getPassword().subSequence(start, end);
        assertEquals(expected, password.subSequence(start, end));
    }

    @Test
    public void toStringCorrect() {
        assertEquals("testValue", password.toString());
    }
}
