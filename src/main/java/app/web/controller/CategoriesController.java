package app.web.controller;

import app.web.dto.Book;
import app.web.dto.NavigationButton;
import app.web.service.BooksService;
import app.web.service.CategoriesService;
import app.web.service.NavigationButtonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Gabriel on 08.04.2017.
 */
@Controller
@RequestMapping("/category")
public class CategoriesController {

    private CategoriesService categoriesService;
    private NavigationButtonsService navigationButtonsService;
    private BooksService booksService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService,
                                NavigationButtonsService navigationButtonsService,
                                BooksService booksService) {
        this.categoriesService = categoriesService;
        this.navigationButtonsService = navigationButtonsService;
        this.booksService = booksService;
    }

    @RequestMapping(method = GET)
    public String categoryRedirect(@RequestParam String categoryUrl,
                                   @RequestParam String categoryName,
                                   Model model) {
        model.addAttribute("categoryUrl", categoryUrl);
        model.addAttribute("categoryName", categoryName);
        return "redirect:/category/{categoryUrl}";
    }

    @RequestMapping(value = "/{categoryUrl}", method = GET)
    public String showCategory(@PathVariable String categoryUrl,
                               @RequestParam String categoryName,
                               @RequestParam(value = "booksLimit", defaultValue = "25") int booksLimit,
                               @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
                               Model model) {
        int offset = booksLimit * pageNumber;
        List<Book> books = booksService.retrieveBooks(categoryName, booksLimit, offset);
        model.addAttribute("books", books);

        Map<String, String> booksCategories = categoriesService.makeBooksCategories();
        model.addAttribute("categories", booksCategories);

        model.addAttribute("categoryName", categoryName);

        int numOfPages = booksService.findNumberOfPagesByCategory(categoryName, booksLimit);
        Set<NavigationButton> navigationButtons = navigationButtonsService.makeNavigationButtons(categoryUrl, numOfPages, pageNumber);
        model.addAttribute("navigationButtons", navigationButtons);
        return "category";
    }
}
