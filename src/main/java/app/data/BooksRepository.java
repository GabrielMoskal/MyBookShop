package app.data;

import app.web.dto.Book;

import java.util.List;

/**
 * Created by Gabriel on 04.04.2017.
 */
public interface BooksRepository {
    Book retrieveBook(long index);
    List<Book> retrieveBooks(String booksCategory, int booksLimit, int booksOffset);
    List<Book> retrieveNewBooks(int booksLimit, int booksOffset);
    List<String> retrieveCategoriesNames();
    int findNumberOfBooksByCategory(String booksCategory);
}
