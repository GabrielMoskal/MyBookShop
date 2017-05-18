package app.web.service;

import app.web.dto.ShoppingCart;

/**
 * Created by Gabriel on 18.05.2017.
 */
public interface ShoppingCartService {
    ShoppingCart makeShoppingCart(String username);

    void insertIntoCart(String username, int bookid, int quantity);
}
