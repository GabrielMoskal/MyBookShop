package app.web.controller;

import app.web.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Gabriel on 02.02.2017.
 */
@Controller
@RequestMapping({"/", "/home"})
public class HomeController {

    private CategoriesService categoriesService;

    @Autowired
    HomeController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @RequestMapping(method = GET)
    public String home(Model model) {
        Map<String, String> myParam = categoriesService.makeBooksCategories();
        model.addAttribute("categories", myParam);
        return "home";
    }

    @RequestMapping(method = GET, value = "/home2")
    public String home2() {
        return "home2";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String test() {
        return "home2";
    }
}
