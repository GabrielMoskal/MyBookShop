package app.web.service;

import app.data.BooksRepository;
import app.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Book> retrieveBooks(String categoryName, int booksLimit, int offset) {
        return booksRepository.findBooks(categoryName, booksLimit, offset);
    }
}
