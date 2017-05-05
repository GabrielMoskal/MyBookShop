package app.web.controller;

import app.web.dto.Book;
import app.web.service.BooksService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Gabriel on 04.05.2017.
 */
public class BookControllerTest {

    private MockMvc mockMvc;
    private Book book;

    @Before
    public void setUp() {
        BooksService booksService = mock(BooksService.class);
        BookController bookController = new BookController(booksService);
        mockMvc = standaloneSetup(bookController).build();
        book = mock(Book.class);
        when(booksService.retrieveBook(123)).thenReturn(book);
    }

    @Test
    public void showBook() throws Exception {
        mockMvc.perform(get("/book/123"))
                .andExpect(model().attribute("book", book))
                .andExpect(view().name("book"));
    }

}
