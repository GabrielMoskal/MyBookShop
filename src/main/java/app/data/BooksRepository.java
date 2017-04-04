package app.data;

import app.web.dto.Book;

/**
 * Created by Gabriel on 04.04.2017.
 */
public interface BooksRepository {
    void insert(Book book);
    Book findBook(int index);
}
