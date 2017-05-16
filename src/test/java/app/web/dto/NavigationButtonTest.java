package app.web.dto;

import com.google.common.testing.EqualsTester;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gabriel on 30.04.2017.
 */
public class NavigationButtonTest {

    private NavigationButton navigationButton;
    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Before
    public void setUp() {
        navigationButton = new NavigationButton(1, "www.testurl.com", "name");
    }

    @Test
    public void assertCompareToWorksProperly() {
        NavigationButton other = makeOtherNavigationButton(1);
        assertEquals(0, navigationButton.compareTo(other));

        other = makeOtherNavigationButton(4);
        assertEquals(-1, navigationButton.compareTo(other));

        other = makeOtherNavigationButton(0);
        assertEquals(1, navigationButton.compareTo(other));
    }

    private NavigationButton makeOtherNavigationButton(int pageIndex) {
        return new NavigationButton(pageIndex, "www.othertesturl.com", "other name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullCompareToValueRaisesException() {
        navigationButton.compareTo(null);
    }

    @Test
    public void equalsAndHashCode() {
        new EqualsTester()
                .addEqualityGroup(
                        navigationButton,
                        new NavigationButton(1, "www.testurl.com", "name"))
                .addEqualityGroup(new NavigationButton(2, "testWord", "testName"),
                        new NavigationButton(2, "testWord", "testName"))
                .testEquals();
    }

    @Test
    public void pageIndexIsNegative() {
        navigationButton = new NavigationButton(-1, "categoryUrl", "name");
        assertValidationErrorExists(navigationButton);
    }

    private void assertValidationErrorExists(NavigationButton button) {
        Set<ConstraintViolation<NavigationButton>> constraintViolations = validator.validate(button);
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void categoryUrlIsNull() {
        navigationButton = new NavigationButton(5, null, "name");
        assertValidationErrorExists(navigationButton);
    }

    @Test
    public void nameIsNull() {
        navigationButton = new NavigationButton(5, "categoryUrl", null);
        assertValidationErrorExists(navigationButton);
    }
}
