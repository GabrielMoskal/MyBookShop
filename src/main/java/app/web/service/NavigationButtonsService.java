package app.web.service;

import app.web.dto.NavigationButton;

import java.util.Set;

/**
 * Created by Gabriel on 11.05.2017.
 */
public interface NavigationButtonsService {
    Set<NavigationButton> makeNavigationButtons(String categoryUrl, int numberOfPages, int currentPageIndex);
    void setNumberOfMiddleButtons(int numberOfMiddleButtons);
    void validateNavigationButtons(Set<NavigationButton> navigationButtons);
}
