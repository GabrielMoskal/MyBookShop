package app.web;

import app.User;
import app.data.UsersRepository;
import app.web.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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
        User user = new User();
        model.addAttribute("user", user);
        return "registerForm";
    }

    @RequestMapping(value="/register", method= POST)
    public String processRegistration(@Valid @ModelAttribute User user,
                                      Errors errors,
                                      Model model) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        userRepository.add(user);
        String username = user.getUsername();
        model.addAttribute("username", username);
        return "redirect:/users/{username}";
    }

    @RequestMapping(value="/{username}", method=GET)
    public String showUserProfile(@PathVariable String username, Model model) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException();
        }
        model.addAttribute(user);
        return "profile";
    }

    @RequestMapping(value="/login", method=GET)
    public String showLoginPage() {
        return "login";
    }
}
