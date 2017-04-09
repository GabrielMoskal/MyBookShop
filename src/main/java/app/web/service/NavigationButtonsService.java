package app.web.service;

import app.web.dto.NavigationButton;
import org.springframework.stereotype.Service;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Gabriel on 09.04.2017.
 */
@Service
public class NavigationButtonsService {
    public SortedSet<NavigationButton> makeNavigationButtons(String categoryUrl, int numberOfPages, int currentPage) {
        NavigationButton firstButton = makeButton(categoryUrl, 0, Integer.toString(1));
        NavigationButton lastButton = makeButton(categoryUrl, numberOfPages - 1, Integer.toString(numberOfPages));

        int begin = currentPage > 0 ? currentPage - 1 : 0;
        int end = currentPage < numberOfPages - 1 ? currentPage + 2 : numberOfPages;
        SortedSet<NavigationButton> middleButtons = makeMiddleButtons(categoryUrl, begin, end);

        SortedSet<NavigationButton> buttons = new TreeSet<>();
        buttons.add(firstButton);
        buttons.add(lastButton);
        buttons.addAll(middleButtons);
        return buttons;
    }

    private NavigationButton makeButton(String categoryUrl, int pageNumber, String name) {
        NavigationButton button = new NavigationButton();
        button.setCategoryUrl(categoryUrl);
        button.setPageNumber(pageNumber);
        button.setName(name);
        return button;
    }

    /**
     *  Makes buttons, the first one pointing to a page with number 'begin', and other with number less than 'end'
     */
    private SortedSet<NavigationButton> makeMiddleButtons(String categoryUrl, int begin, int end) {
        SortedSet<NavigationButton> result = new TreeSet<>();
        for (int i = begin; i < end; i++) {
            if (i <= 0) {
                continue;
            }
            String buttonName = Integer.toString(i + 1);
            NavigationButton button = makeButton(categoryUrl, i, buttonName);
            result.add(button);
        }
        return result;
    }
}
