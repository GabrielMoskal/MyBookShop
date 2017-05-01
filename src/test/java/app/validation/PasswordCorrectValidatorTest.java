package app.validation;

import app.web.dto.Password;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Gabriel on 01.05.2017.
 */
public class PasswordCorrectValidatorTest {
    private PasswordCorrectValidator validator;

    @Before
    public void setUp() {
        validator = new PasswordCorrectValidator();
    }

    @Test
    public void equalValuesAreValid() {
        Password password = new Password("testValue", "testValue");
        assertTrue(validator.isValid(password, null));
    }

    @Test
    public void unequalValuesAreInvalid() {
        Password password = new Password("testValue", "otherValue");
        assertFalse(validator.isValid(password, null));
    }

    @Test
    public void nullValueIsInvalid() {
        assertTrue(validator.isValid(null, null));
    }
}
