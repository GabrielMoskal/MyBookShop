package app.web.controller;

import app.web.dto.UserRegistrationDetails;
import app.data.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Gabriel on 02.02.2017.
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    private UsersRepository userRepository;

    @Autowired
    public UsersController(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value="/register", method= GET)
    public String showRegistrationForm(Model model) {
        UserRegistrationDetails details = new UserRegistrationDetails();
        model.addAttribute("details", details);
        return "registerForm";
    }

    @RequestMapping(value="/register", method= POST)
    public String processRegistration(@Valid @ModelAttribute(name = "details") UserRegistrationDetails details,
                                      Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        userRepository.register(details);
        return "redirect:/home";
    }

    @RequestMapping(value = "/profile", method = GET)
    public String showProfile(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("username", username);
        return "redirect:/users/{username}";
    }

    @RequestMapping(value="/{username}", method=GET)
    public String showUserProfile(@PathVariable String username, Model model) {
        UserRegistrationDetails details = userRepository.findByUsername(username);
        model.addAttribute(details);
        return "profile";
    }

    @RequestMapping(value="/login", method=GET)
    public String showLoginPage() {
        return "login";
    }
}
