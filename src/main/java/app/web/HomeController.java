package app.web;

import app.data.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Gabriel on 02.02.2017.
 */
@Controller
@RequestMapping({"/", "/home"})
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping(method = RequestMethod.POST)
    public String test(Model model) {
        usersRepository.findByUsername("user");
        return "home";
    }
}
