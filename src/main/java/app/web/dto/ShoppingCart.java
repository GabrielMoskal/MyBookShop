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

    public void putBook(Integer bookid, Integer quantity) {
        Integer totalQuantity = bookidToQuantity.get(bookid);
        if (totalQuantity == null) {
            totalQuantity = quantity;
        }
        else {
            totalQuantity += quantity;
        }
        bookidToQuantity.put(bookid, totalQuantity);
    }

    public void putBook(Map<Integer, Integer> bookidToQuantity) {
        this.bookidToQuantity.putAll(bookidToQuantity);
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
