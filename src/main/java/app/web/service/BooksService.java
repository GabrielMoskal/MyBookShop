package app.web.service;

import app.data.BooksRepository;
import app.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gabriel on 08.04.2017.
 */
@Service
public class BooksService {

    private BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Book retrieveBook(int bookId) {
        return booksRepository.retrieveBook(bookId);
    }

    public List<Book> retrieveBooks(String categoryName, int booksLimit, int offset) {
        return booksRepository.retrieveBooks(categoryName, booksLimit, offset);
    }

    public List<Book> retrieveNewBooks(int booksLimit, int offset) {
        return booksRepository.retrieveNewBooks(booksLimit, offset);
    }

    public int findNumberOfPagesByCategory(String category, int booksLimitPerPage) {
        int numOfBooks = booksRepository.findNumberOfBooksByCategory(category);
        double numOfPages = (double)numOfBooks / booksLimitPerPage;
        return (int)Math.ceil(numOfPages);
    }
}