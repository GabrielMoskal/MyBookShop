package app.data;

import app.web.dto.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gabriel on 11.04.2017.
 */
@Repository
public class JdbcShoppingCartsRepository implements ShoppingCartsRepository {

    private NamedParameterJdbcOperations jdbcOperations;
    private BooksRepository booksRepository;
    private UsersRepository usersRepository;

    @Autowired
    public JdbcShoppingCartsRepository(@Qualifier("jdbcUsers") NamedParameterJdbcOperations jdbcOperations,
                                       BooksRepository booksRepository,
                                       UsersRepository usersRepository) {
        this.jdbcOperations = jdbcOperations;
        this.booksRepository = booksRepository;
        this.usersRepository = usersRepository;
    }

    public void insertIntoCart(final String username, int bookid, int quantity) {
        final String INSERT_INTO_CART = "INSERT INTO shopping_cart(username, bookid, quantity) " +
                "VALUES(username = :username, bookid = :bookid, quantity = :quantity) " +
                "ON DUPLICATE KEY UPDATE quantity = quantity + :quantity;";

        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("bookid", bookid);
        params.put("quantity", quantity);
        jdbcOperations.update(INSERT_INTO_CART, params);
    }

    // TODO
    /* retrieve list/map of shopping cart content, then add it to a new shopping cart which would be returned
     * to the user */
    public ShoppingCart retrieveShoppingCart(String username) {

    }
}
