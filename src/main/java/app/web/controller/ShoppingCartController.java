package app.web.controller;

import app.web.dto.ShoppingCart;
import app.web.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Gabriel on 11.04.2017.
 */
@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
    private ShoppingCartService shoppingCartService;

    @Autowired
    ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @RequestMapping(method = GET)
    public String getCart(Principal principal, Model model) {
        String username = principal.getName();
        ShoppingCart cart = shoppingCartService.makeShoppingCart(username);
        model.addAttribute("cart", cart);
        return "shoppingCart";
    }

    @RequestMapping(method = POST)
    public String updateCart(@RequestParam(value = "bookid") int bookid,
                             @RequestParam(value = "quantity") int quantity,
                             HttpServletRequest request,
                             Principal principal) {
        String username = principal.getName();
        shoppingCartService.addIntoCart(username, bookid, quantity);
        return redirectToPreviousPage(request);
    }

    private String redirectToPreviousPage(HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        if (referer == null) {
            return "/";
        }
        else {
            return "redirect:" + referer;
        }
    }
}
