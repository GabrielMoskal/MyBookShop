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
        }
        model.addAttribute("categories", myParam);
        return "home";
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

        return "home2";
    }
}
