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
        addCategoryUrlIntoModel(model, categoryUrl);
        addCategoryNameIntoModel(model, categoryName);
        return "redirect:/category/{categoryUrl}";
    }

    private void addCategoryUrlIntoModel(Model model, String categoryUrl) {
        model.addAttribute("categoryUrl", categoryUrl);
    }

    private void addCategoryNameIntoModel(Model model, String categoryName) {
        model.addAttribute("categoryName", categoryName);
    }

    @RequestMapping(value = "/{categoryUrl}", method = GET)
    public String showCategory(@PathVariable String categoryUrl,
                               @RequestParam String categoryName,
                               @RequestParam(value = "booksLimit", defaultValue = "25") int booksLimit,
                               @RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex,
                               Model model) {

        addBooksIntoModel(model, categoryName, booksLimit, pageIndex);
        addCategoriesIntoModel(model);
        addCategoryNameIntoModel(model, categoryName);
        addNavigationButtonsIntoModel(model, categoryUrl, categoryName, booksLimit, pageIndex);
        return "category";
    }

    private void addBooksIntoModel(Model model, String categoryName, int booksLimit, int pageIndex) {
        int offset = booksLimit * pageIndex;
        List<Book> books = booksService.retrieveBooks(categoryName, booksLimit, offset);
        model.addAttribute("books", books);
    }

    private void addCategoriesIntoModel(Model model) {
        Map<String, String> booksCategories = categoriesService.makeBooksCategories();
        model.addAttribute("categories", booksCategories);
    }

    private void addNavigationButtonsIntoModel(Model model, String categoryUrl, String categoryName, int booksLimit, int pageIndex) {
        int numOfPages = booksService.findNumberOfPagesByCategory(categoryName, booksLimit);
        Set<NavigationButton> navigationButtons = navigationButtonsService.makeNavigationButtons(categoryUrl, numOfPages, pageIndex);
        model.addAttribute("navigationButtons", navigationButtons);
    }
}

