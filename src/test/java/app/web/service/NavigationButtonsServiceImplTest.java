package app.web.service;

import app.web.dto.NavigationButton;
import org.junit.Before;
import org.junit.Test;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gabriel on 05.05.2017.
 */
public class NavigationButtonsServiceImplTest {

    private NavigationButtonsServiceImpl service;
    private Set<NavigationButton> expected;

    @Before
    public void setUp() {
        expected = new TreeSet<>();
        service = new NavigationButtonsServiceImpl();
        service.setNumberOfMiddleButtons(3);
        service.setCategoryUrl("categoryUrl");
        service.setCurrentPageIndex(5);
        service.setNumberOfPages(123);
    }

    @Test
    public void makeNavigationButtons() {
        Set<NavigationButton> result = service.makeNavigationButtons("categoryUrl", 123, 5);

        addButtonIntoExpected(0, "1");
        addButtonIntoExpected(4, "5");
        addButtonIntoExpected(5, "6");
        addButtonIntoExpected(6, "7");
        addButtonIntoExpected(122, "123");

        assertEquals(expected, result);
    }

    private void addButtonIntoExpected(int pageIndex, String name) {
        expected.add(new NavigationButton(pageIndex, "categoryUrl", name));
    }

    @Test(expected = InvalidStateException.class)
    public void validateNavigationButtonsThrowsException() {
        Set<NavigationButton> result = service.makeNavigationButtons("categoryUrl", -123, 5);
        service.validateNavigationButtons(result);
    }

    @Test
    public void validateNavigationButtonsWithValidButtonsDoNotThrows() {
        Set<NavigationButton> result = service.makeNavigationButtons("categoryUrl", 123, 5);
        service.validateNavigationButtons(result);
    }
}
