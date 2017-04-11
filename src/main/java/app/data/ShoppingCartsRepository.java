package app.data;

import app.web.dto.ShoppingCart;

/**
 * Created by Gabriel on 11.04.2017.
 */
public interface ShoppingCartsRepository {
    void insertIntoCart(String username, int bookid, int quantity);
    ShoppingCart retrieveShoppingCart(String username);
}
