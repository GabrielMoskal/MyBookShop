package app.web.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gabriel on 30.04.2017.
 */
public class BookTest {

    private Book book;

    @Before
    public void setUp() {
        this.book = new Book.Builder()
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
    public void bookBuilderWorksCorrecly() {
        assertEquals("author", book.getAuthor());
        assertEquals("category", book.getCategory());
        assertEquals("copying", book.getCopying());
        assertEquals("description", book.getDescription());
        assertEquals("devices", book.getDevices());
        assertEquals("format", book.getFormat());
        assertEquals("imgUrl", book.getImgUrl());
        assertEquals(1L, (long)book.getIndex());
        assertEquals("language", book.getLanguage());
        assertEquals(2, (int)book.getPages());
        assertEquals("printing", book.getPrinting());
        assertEquals("publisher", book.getPublisher());
        assertEquals("title", book.getTitle());
        assertEquals("translator", book.getTranslator());
        assertEquals(3, (int)book.getYear());
    }
}
