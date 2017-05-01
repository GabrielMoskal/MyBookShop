package app.web.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by Gabriel on 11.04.2017.
 */
@Getter
@ToString
@EqualsAndHashCode(of = {"bookid", "bookTitle"})
public class ShoppingCartItem {
    private int bookid;
    private String bookTitle;
    private int quantity;

    public ShoppingCartItem(int bookid, final String bookTitle, int quantity) {
        this.bookid = bookid;
        this.bookTitle = bookTitle;
        this.quantity = quantity;
    }
}
