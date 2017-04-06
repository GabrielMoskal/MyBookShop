package app.web.controller;

import app.data.BooksRepository;
import app.web.dto.Book;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Gabriel on 02.02.2017.
 */
@Controller
@RequestMapping({"/", "/home"})
public class HomeController {

    private BooksRepository booksRepository;

    @Autowired
    HomeController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @RequestMapping(method = GET)
    public String home(Model model) {
        List<String> booksCategories = booksRepository.retrieveCategoriesNames();

        Map<String, String> myParam = new HashMap<>();
        for (String bookCategory : booksCategories) {
            myParam.put(makeCategoryUrl(bookCategory), bookCategory);
            System.out.print(myParam);
        }
        model.addAttribute("categories", myParam);
        return "home";
    }

    @RequestMapping(method = GET, value = "/category")
    public String categoryRedirect(@RequestParam String categoryUrl, Model model) {
        System.out.println("jestem tutaj");
        System.out.println(categoryUrl);
        if (categoryUrl == null) {
            System.out.print("kappa");
        }
        /*


        System.out.println(categoryUrl);

        model.addAttribute("books", newBooks);
        categoryUrl = makeCategoryUrl(categoryUrl);
        model.addAttribute("categoryUrl", categoryUrl);
        */
        model.addAttribute("categoryUrl", categoryUrl);
        return "redirect:/home/{categoryUrl}";
    }

    @RequestMapping(value = "/home/{categoryUrl}", method = GET)
    public String showCategory(@PathVariable String categoryUrl, Model model) {
        List<Book> books = booksRepository.findBooks(categoryUrl);
        List<Book> newBooks = new ArrayList<>();
        if (!books.isEmpty()) {
            for (int i = 0; i < 20; i++) {
                newBooks.add(books.get(i));
            }
        }
        model.addAttribute("books", newBooks);
        return "category";
    }


    private String makeCategoryUrl(final String concreteCategory) {
        String result = concreteCategory.toLowerCase();
        result = StringUtils.stripAccents(result);
        result = result.replace('ł', 'l')
                       .replace(' ', '-');
        try {
            URLEncoder.encode(result, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @RequestMapping(method = GET, value = "/home2")
    public String home2(Model model) {
        return "home2";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String test() {
        List<Book> books = booksRepository.findBooks("kryminał");
        for (Book book : books) {
            System.out.println(book);
        }
        return "home2";
    }
}
