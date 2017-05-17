package app.web.service;

import app.web.dto.Book;

import java.util.List;

/**
 * Created by Gabriel on 17.05.2017.
 */
public interface BooksService {
    Book retrieveBook(long bookId);

    List<Book> retrieveBooks(String categoryName, int booksLimit, int offset);

    List<Book> retrieveNewBooks(int booksLimit, int offset);

    int findNumberOfPagesByCategory(String category, int booksLimitPerPage);
}
