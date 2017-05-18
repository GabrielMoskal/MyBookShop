package app.web.service;

import app.data.BooksRepository;
import app.data.ShoppingCartsRepository;
import app.web.dto.Book;
import app.web.dto.ShoppingCart;
import app.web.dto.ShoppingCartItem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Gabriel on 17.05.2017.
 */
public class ShoppingCartServiceImplTest {

    private ShoppingCartsRepository cartsRepository;
    private BooksRepository booksRepository;
    private ShoppingCartService cartService;

    @Before
    public void setUp() {
        cartsRepository = mock(ShoppingCartsRepository.class);
        booksRepository = mock(BooksRepository.class);
        cartService = new ShoppingCartServiceImpl(cartsRepository, booksRepository);
    }

    @Test
    public void makeShoppingCart() {
        prepareCartsRepository();
        prepareBooksRepository();

        ShoppingCart expected = makeExpectedShoppingCart();
        ShoppingCart result = cartService.makeShoppingCart("username");
        assertEquals(expected, result);
    }

    private void prepareCartsRepository() {
        List<Map<String, Object>> categoriesToColumns = makeCategoriesToColumns();
        when(cartsRepository.retrieveBookidsToQuantities(anyString()))
                .thenReturn(categoriesToColumns);
    }

    private List<Map<String, Object>> makeCategoriesToColumns() {
        List<Map<String, Object>> categoriesToColumns = new ArrayList<>();
        categoriesToColumns.add(makeItem(123, 4));
        categoriesToColumns.add(makeItem(3, 12));
        return categoriesToColumns;
    }

    private void prepareBooksRepository() {
        Book book = mock(Book.class);
        when(book.getTitle()).thenReturn("bookTitle");
        when(booksRepository.retrieveBook(anyLong())).thenReturn(book);
    }

    private Map<String, Object> makeItem(int bookidValue, int quantityValue) {
        Map<String, Object> item = new HashMap<>();
        item.put("bookid", bookidValue);
        item.put("quantity", quantityValue);
        return item;
    }

    private ShoppingCart makeExpectedShoppingCart() {
        ShoppingCart cart = new ShoppingCart();
        cart.putItem(new ShoppingCartItem(123, "bookTitle", 4));
        cart.putItem(new ShoppingCartItem(3, "bookTitle", 12));
        return cart;
    }

    @Test
    public void insertIntoCart() {
        String username = "username";
        int bookid = 123;
        int quantity = 12;
        cartService.insertIntoCart(username, bookid, quantity);
        verify(cartsRepository, times(1)).insertIntoCart(username, bookid, quantity);
        verify(cartsRepository, times(1)).deleteEmptyRowFromCart(username, bookid);
    }
}
