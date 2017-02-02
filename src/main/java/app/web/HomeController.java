package app.web;

import org.springframework.stereotype.Controller;
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
}
