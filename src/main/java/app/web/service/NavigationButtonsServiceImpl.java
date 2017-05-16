package app.web.service;

import app.web.dto.NavigationButton;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import sun.plugin.dom.exception.InvalidStateException;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Gabriel on 09.04.2017.
 */
@Service
@Scope(
        value = WebApplicationContext.SCOPE_REQUEST,
        proxyMode = ScopedProxyMode.INTERFACES)
@Setter
public class NavigationButtonsServiceImpl implements NavigationButtonsService {

    private int numberOfMiddleButtons;
    private String categoryUrl;
    private int numberOfPages;
    private int currentPageIndex;

    NavigationButtonsServiceImpl() {
        setNumberOfMiddleButtons(0);
        setCategoryUrl("noCategoryUrl");
        setNumberOfPages(0);
        setCurrentPageIndex(0);
    }

    @Override
    public Set<NavigationButton> makeNavigationButtons(String categoryUrl, int numberOfPages, int currentPageIndex) {
        setCategoryUrl(categoryUrl);
        setNumberOfPages(numberOfPages);
        setCurrentPageIndex(currentPageIndex);
        return makeNavigationButtons();
    }

    private Set<NavigationButton> makeNavigationButtons() {
        Set<NavigationButton> buttons = new TreeSet<>();
        buttons.add(makeFirstButton());
        buttons.add(makeLastButton());
        buttons.addAll(makeMiddleButtons());
        return buttons;
    }

    private NavigationButton makeFirstButton() {
        int pageIndex = 0;
        String buttonName = Integer.toString(1);
        return makeButton(pageIndex, buttonName);
    }

    private NavigationButton makeButton(int pageIndex, String name) {
        return new NavigationButton(pageIndex, categoryUrl, name);
    }

    private NavigationButton makeLastButton() {
        int pageIndex = numberOfPages - 1;
        String buttonName = Integer.toString(numberOfPages);
        return makeButton(pageIndex, buttonName);
    }

    private Set<NavigationButton> makeMiddleButtons() {
        /* currentPageIndex should be on the middle, so compute position */
        int begin = currentPageIndex - (numberOfMiddleButtons / 2);
        int end = begin + numberOfMiddleButtons;
        int lastPageIndex = numberOfPages - 1;
        end = end <= lastPageIndex ? end : lastPageIndex;
        return makeOrderedButtons(begin, end);
    }

    /**
     *  Makes buttons, the first one pointing to a page with index 'begin', and other with number 1 less than 'end'
     *  @return set of ordered buttons by pageNumber
     */
    private Set<NavigationButton> makeOrderedButtons(int begin, int end) {
        Set<NavigationButton> result = new TreeSet<>();
        for (int i = begin; i < end; i++) {
            if (i <= 0) {
                continue;
            }
            String buttonName = Integer.toString(i + 1);
            NavigationButton button = makeButton(i, buttonName);
            result.add(button);
        }
        return result;
    }

    public void validateNavigationButtons(Set<NavigationButton> navigationButtons) throws InvalidStateException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        navigationButtons.forEach((button) -> {
            if (validator.validate(button).size() > 0) {
                throw new InvalidStateException("NavigationButtons have invalid state");
            }
        });
    }
}
