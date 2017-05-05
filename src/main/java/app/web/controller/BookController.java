package app.web.controller;

import app.web.dto.Book;
import app.web.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Gabriel on 09.04.2017.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    private BooksService booksService;

    @Autowired
    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }

    @RequestMapping(value = "/{bookIndex}", method = GET)
    public String showBook(@PathVariable int bookIndex,
                           Model model) {
        Book book = booksService.retrieveBook(bookIndex);
        model.addAttribute("book", book);
        return "book";
    }
}
