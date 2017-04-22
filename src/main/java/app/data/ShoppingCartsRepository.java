package app.data;

import java.util.List;
import java.util.Map;

/**
 * Created by Gabriel on 11.04.2017.
 */
public interface ShoppingCartsRepository {
    void insertIntoCart(String username, int bookid, int quantity);
    void deleteEmptyRowFromCart(final String username, int bookid);
    List<Map<String, Object>> retrieveBookidsToQuantities(String username);
}
