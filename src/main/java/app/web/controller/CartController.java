package app.web.controller;

import app.web.dto.ShoppingCart;
import app.web.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Gabriel on 11.04.2017.
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    private ShoppingCartService shoppingCartService;

    @Autowired
    CartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @RequestMapping(method = GET)
    public String getCart(Principal principal, Model model) {
        String username = principal.getName();
        ShoppingCart cart = shoppingCartService.makeShoppingCart(username);
        model.addAttribute("cart", cart);
        return "shoppingCart";
    }
}
