package app.web.dto;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by Gabriel on 11.04.2017.
 */
@Getter
@ToString
public class ShoppingCartItem {
    private int bookid;
    private String bookTitle;
    private int quantity;

    public ShoppingCartItem(int bookid, final String bookTitle, int quantity) {
        this.bookid = bookid;
        this.bookTitle = bookTitle;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCartItem item = (ShoppingCartItem) o;

        if (bookid != item.bookid) return false;
        return bookTitle != null ? bookTitle.equals(item.bookTitle) : item.bookTitle == null;
    }

    @Override
    public int hashCode() {
        int result = bookid;
        result = 31 * result + (bookTitle != null ? bookTitle.hashCode() : 0);
        return result;
    }
}
