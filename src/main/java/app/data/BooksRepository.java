package app.data;

import app.web.dto.Book;

import java.util.List;
import java.util.Map;

/**
 * Created by Gabriel on 04.04.2017.
 */
public interface BooksRepository {
    void insert(Book book);
    Book findBook(int index);
    List<Book> findBooks(String category);
    List<Map<String, Object>> findCategories();
}
