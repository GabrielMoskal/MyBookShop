package app.web.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gabriel on 30.04.2017.
 */
public class NavigationButtonTest {

    private NavigationButton navigationButton;

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

    @Test(expected = NullPointerException.class)
    public void nullCompareToValueRaisesException() {
        navigationButton.compareTo(null);
    }
}
