package app.web.controller;

import app.data.BooksRepository;
import app.data.UsersRepository;
import app.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Gabriel on 02.02.2017.
 */
@Controller
@RequestMapping({"/", "/home"})
public class HomeController {

    BooksRepository booksRepository;

    @Autowired
    HomeController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        List<Map<String, Object>> categories = booksRepository.findCategories();
        List<String> category = new ArrayList<>();
        for (Map<String, Object> cat : categories) {
            category.add((String)cat.get("kategoria"));
        }
        model.addAttribute("categories", category);
        return "home";
    }

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping(method = RequestMethod.POST)
    public String test() {
        /*
        System.out.println(usersRepository.findByUsername("Tomek"));
        System.out.println(booksRepository.findBook(10002810));
        List<Map<String, Object>> testList = booksRepository.findCategories();
        System.out.println(testList.size());
        Map<String, Object> testMap = new HashMap<>();
        for (Map<String, Object> map : testList){
            testMap.putAll(map);
            System.out.println(map);
            System.out.println(testMap);
        }
        */
        List<Book> books = booksRepository.findBooks("kryminał");
        for (Book book : books) {
            System.out.println(book);
        }
        return "home";
    }
}
