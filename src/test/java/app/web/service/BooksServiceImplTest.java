package app.web.service;

import app.data.BooksRepository;
import app.web.dto.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Gabriel on 17.05.2017.
 */
public class BooksServiceImplTest {

    private Book preparedBook;
    private BooksRepository repository;
    private BooksService service;
    private List<Book> expectedBooks;

    @Before
    public void setUp() {
        preparedBook = makeBook();
        repository = mock(BooksRepository.class);
        service = new BooksServiceImpl(repository);
        expectedBooks = new ArrayList<>();
        expectedBooks.add(preparedBook);
    }

    @Test
    public void retrieveBook() {
        when(repository.retrieveBook(anyLong())).thenReturn(preparedBook);
        Book result = service.retrieveBook(1L);
        assertEquals(preparedBook, result);
    }

    private Book makeBook() {
        return new Book.Builder()
                .author("author")
                .category("category")
                .copying("copying")
                .description("description")
                .devices("devices")
                .format("format")
                .imgUrl("imgUrl")
                .index(1L)
                .language("language")
                .pages(2)
                .printing("printing")
                .publisher("publisher")
                .title("title")
                .translator("translator")
                .year(3)
                .build();
    }

    @Test
    public void retrieveBooks() {
        when(repository.retrieveBooks(anyString(), anyInt(), anyInt()))
                .thenReturn(expectedBooks);
        List<Book> result = service.retrieveBooks("categoryName", 1, 0);
        assertEquals(expectedBooks, result);
    }

    @Test
    public void retrieveNewBooks() {
        when(repository.retrieveNewBooks(anyInt(), anyInt()))
                .thenReturn(expectedBooks);
        List<Book> result = service.retrieveNewBooks(1, 0);
        assertEquals(expectedBooks, result);
    }

    @Test
    public void findNumberOfPagesByCategory() {
        when(repository.findNumberOfBooksByCategory(anyString()))
                .thenReturn(131);
        assertFindNumerOfPagesWorksProperly(6, 25);
        assertFindNumerOfPagesWorksProperly(1, 150);
        assertFindNumerOfPagesWorksProperly(131, 1);
    }

    private void assertFindNumerOfPagesWorksProperly(int expected, int booksLimitPerPage) {
        int result = service.findNumberOfPagesByCategory("category", booksLimitPerPage);
        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findNumberOfPagesByCategoryThrowsException() {
        assertFindNumerOfPagesWorksProperly(0, -1);
        assertFindNumerOfPagesWorksProperly(0, 0);
    }
}

