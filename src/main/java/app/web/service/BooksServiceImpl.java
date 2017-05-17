package app.web.service;

import app.data.BooksRepository;
import app.web.dto.Book;
import java.lang.IllegalArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gabriel on 08.04.2017.
 */
@Service
public class BooksServiceImpl implements BooksService {

    private BooksRepository booksRepository;

    @Autowired
    public BooksServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public Book retrieveBook(long bookId) {
        return booksRepository.retrieveBook(bookId);
    }

    @Override
    public List<Book> retrieveBooks(String categoryName, int booksLimit, int offset) {
        return booksRepository.retrieveBooks(categoryName, booksLimit, offset);
    }

    @Override
    public List<Book> retrieveNewBooks(int booksLimit, int offset) {
        return booksRepository.retrieveNewBooks(booksLimit, offset);
    }

    @Override
    public int findNumberOfPagesByCategory(String category, int booksLimitPerPage) {
        if (!isIntegerPositive(booksLimitPerPage)) {
            throw new IllegalArgumentException("booksLimitPerPage should be positive");
        }
        int numOfBooks = booksRepository.findNumberOfBooksByCategory(category);
        double numOfPages = (double)numOfBooks / booksLimitPerPage;
        return (int)Math.ceil(numOfPages);
    }

    private boolean isIntegerPositive(int booksLimitPerPage) {
        return booksLimitPerPage > 0;
    }
}