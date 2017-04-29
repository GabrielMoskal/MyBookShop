package app.web.service;

import app.data.BooksRepository;
import app.data.ShoppingCartsRepository;
import app.web.dto.Book;
import app.web.dto.ShoppingCart;
import app.web.dto.ShoppingCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Gabriel on 11.04.2017.
 */
@Service
public class ShoppingCartService {

    private ShoppingCartsRepository cartsRepository;
    private BooksRepository booksRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartsRepository cartsRepository,
                               BooksRepository booksRepository) {
        this.cartsRepository = cartsRepository;
        this.booksRepository = booksRepository;
    }

    public ShoppingCart makeShoppingCart(String username) {
        List<Map<String, Object>> categoriesToColumns = cartsRepository.retrieveBookidsToQuantities(username);
        ShoppingCart shoppingCart = new ShoppingCart();

        for (Map<String, Object> categoryToColumn : categoriesToColumns) {
            // TODO
            // 1. Can refactor this (make another method and make Lambda injections?
            // 2. Can reduce this class? not to generate names here, generate in views?
            Integer bookid = (Integer)categoryToColumn.get("bookid");
            Integer quantity = (Integer)categoryToColumn.get("quantity");
            Book book = booksRepository.retrieveBook(bookid);
            String title = book.getTitle();

            ShoppingCartItem item = new ShoppingCartItem(bookid, title, quantity);
            shoppingCart.putItem(item);
        }
        return shoppingCart;
    }

    public void insertIntoCart(String username, int bookid, int quantity) {
        cartsRepository.insertIntoCart(username, bookid, quantity);
        cartsRepository.deleteEmptyRowFromCart(username, bookid);
    }
}
