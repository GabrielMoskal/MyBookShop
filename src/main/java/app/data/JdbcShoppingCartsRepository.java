package app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gabriel on 11.04.2017.
 */
@Repository
public class JdbcShoppingCartsRepository implements ShoppingCartsRepository {

    private NamedParameterJdbcOperations jdbcOperations;

    @Autowired
    public JdbcShoppingCartsRepository(@Qualifier("jdbcUsers") NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public void insertIntoCart(final String username, int bookid, int quantity) {
        final String INSERT_INTO_CART = "INSERT INTO shopping_cart(username, bookid, quantity) " +
                "VALUES(:username, :bookid, :quantity) " +
                "ON DUPLICATE KEY UPDATE quantity = quantity + :quantity;";

        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("bookid", bookid);
        params.put("quantity", quantity);
        jdbcOperations.update(INSERT_INTO_CART, params);
    }

    public void deleteEmptyRowFromCart(final String username, int bookid) {
        final String DELETE_FROM_CART = "DELETE FROM shopping_cart " +
                "WHERE username = :username " +
                "AND bookid = :bookid " +
                "AND quantity <= 0;";

        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("bookid", bookid);
        jdbcOperations.update(DELETE_FROM_CART, params);
    }

    public List<Map<String, Object>> retrieveBookidsToQuantities(String username) {
        final String SELECT_FROM_CART = "SELECT bookid, quantity " +
                "FROM shopping_cart " +
                "WHERE username = :username;";
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);

        return jdbcOperations.queryForList(SELECT_FROM_CART, params);
    }
}
