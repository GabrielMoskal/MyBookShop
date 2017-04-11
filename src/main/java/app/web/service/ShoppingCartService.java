package app.web.service;

import app.data.BooksRepository;
import app.data.ShoppingCartsRepository;
import app.web.dto.Book;
import app.web.dto.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by Gabriel on 11.04.2017.
 */
public class ShoppingCartService {
    private ShoppingCartsRepository cartsRepository;
    private BooksRepository booksRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartsRepository cartsRepository,
                               BooksRepository booksRepository) {
        this.cartsRepository = cartsRepository;
        this.booksRepository = booksRepository;
    }

    public void test(String username) {
        ShoppingCart cart = cartsRepository.retrieveShoppingCart(username);
        Map<Integer, Integer> bookidToQuantity = cart.getBookidToQuantity();
        for (int bookid : bookidToQuantity.keySet()) {
            Book book = booksRepository.retrieveBook(bookid);
        }
    }
}
