package app.web.controller;

import app.data.BooksRepository;
import app.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        List<String> booksCategories = booksRepository.retrieveCategoriesNames();
        model.addAttribute("categories", booksCategories);
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/home2")
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
