package app.web.controller;

import app.data.BooksRepository;
import app.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Gabriel on 09.04.2017.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    private BooksRepository booksRepository;

    @Autowired
    public BookController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @RequestMapping(method = GET)
    public String bookRedirect(@ModelAttribute Book book,
                               Model model) {
        model.addAttribute("bookIndex", book.getIndex());
        return "redirect:/book/{bookIndex}";
    }

    @RequestMapping(value = "/{bookIndex}", method = GET)
    public String showBook(@PathVariable int bookIndex,
                           Model model) {
        Book book = booksRepository.retrieveBook(bookIndex);
        model.addAttribute("book", book);
        return "book";
    }
}
