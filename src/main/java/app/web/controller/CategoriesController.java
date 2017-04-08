package app.web.controller;

import app.data.BooksRepository;
import app.web.dto.Book;
import app.web.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Gabriel on 08.04.2017.
 */
@Controller
@RequestMapping("/category")
public class CategoriesController {

    private BooksRepository booksRepository;
    private CategoriesService categoriesService;

    @Autowired
    public CategoriesController(BooksRepository booksRepository, CategoriesService categoriesService) {
        this.booksRepository = booksRepository;
        this.categoriesService = categoriesService;
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
                               @RequestParam(value = "booksLimit", defaultValue = "15") int booksLimit,
                               @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
                               Model model) {
        int offset = booksLimit * pageNumber;
        List<Book> books = booksRepository.findBooks(categoryName, booksLimit, offset);
        model.addAttribute("books", books);

        Map<String, String> myParam = categoriesService.makeBooksCategories();
        model.addAttribute("categories", myParam);

        return "category";
    }
}
