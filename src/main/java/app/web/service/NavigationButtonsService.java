package app.web.service;

import app.web.dto.NavigationButton;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Gabriel on 09.04.2017.
 */
@Service
public class NavigationButtonsService {

    // TODO make variable number of buttons
    private static final int NUM_OF_MIDDLE_BUTTONS = 3;

    private String categoryUrl;
    private int numberOfPages;
    private int currentPageIndex;

    NavigationButtonsService() {
        this.categoryUrl = "noCategoryChosen";
        this.numberOfPages = 0;
        this.currentPageIndex = 0;
    }

    public Set<NavigationButton> makeNavigationButtons(String categoryUrl, int numberOfPages, int currentPageIndex) {
        this.categoryUrl = categoryUrl;
        this.numberOfPages = numberOfPages;
        this.currentPageIndex = currentPageIndex >= 0 ? currentPageIndex : 0;

        return makeNavigationButtons();
    }

    private Set<NavigationButton> makeNavigationButtons() {
        NavigationButton firstButton = makeFirstButton();
        NavigationButton lastButton = makeLastButton();
        Set<NavigationButton> middleButtons = makeMiddleButtons();

        Set<NavigationButton> buttons = new TreeSet<>();
        buttons.add(firstButton);
        buttons.add(lastButton);
        buttons.addAll(middleButtons);
        return buttons;
    }

    private NavigationButton makeFirstButton() {
        int pageIndex = 0;
        String buttonName = Integer.toString(1);
        return makeButton(pageIndex, buttonName);
    }

    private NavigationButton makeButton(int pageIndex, String name) {
        NavigationButton button = new NavigationButton();
        button.setCategoryUrl(categoryUrl);
        button.setPageNumber(pageIndex);
        button.setName(name);
        return button;
    }

    private NavigationButton makeLastButton() {
        int pageIndex = numberOfPages - 1;
        String buttonName = Integer.toString(numberOfPages);
        return makeButton(pageIndex, buttonName);
    }

    private Set<NavigationButton> makeMiddleButtons() {
        /* currentPageIndex should be on the middle, so begin with currentPage - NUM_OF_MIDDLE_BUTTONS / 2 */
        int begin = currentPageIndex - (NUM_OF_MIDDLE_BUTTONS / 2);
        int end = begin + NUM_OF_MIDDLE_BUTTONS;
        int lastPageIndex = numberOfPages - 1;
        end = end <= lastPageIndex ? end : lastPageIndex;
        return makeOrderedButtons(begin, end);
    }

    /**
     *  Makes buttons, the first one pointing to a page with index 'begin', and other with number less than 'end'
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
}
