package app.web.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gabriel on 11.04.2017.
 */
public class ShoppingCart {
    private String username;
    private Map<Integer, Integer> bookidToQuantity;

    public ShoppingCart(String username) {
        setUsername(username);
        bookidToQuantity = new HashMap<>();
    }

    public void putBook(Integer bookid, Integer bookquantity) {
        Integer totalQuantity = bookidToQuantity.get(bookid);
        if (totalQuantity == null) {
            totalQuantity = bookquantity;
        }
        else {
            totalQuantity += bookquantity;
        }
        bookidToQuantity.put(bookid, totalQuantity);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public Map<Integer, Integer> getBookidToQuantity() {
        return bookidToQuantity;
    }
}
