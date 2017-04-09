package app.data;

import app.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gabriel on 04.04.2017.
 */
@Repository
public class JdbcBooksRepository implements BooksRepository {

    private NamedParameterJdbcOperations jdbcOperations;

    @Autowired
    public JdbcBooksRepository(@Qualifier("jdbcBooks") NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public void insert(Book book) {
        insertIntoBooks(book);
        insertIntoBooksCategories(book);
    }

    private void insertIntoBooks(Book book) {
        final String INSERT_BOOK = "INSERT INTO books (bookid, title, author, publisher, " +
                "release_year, pages, book_format, devices, printing, " +
                "copying, translator, book_language, description, image_url)" +
                "VALUES (:index, :title, :author, :publisher, :year, :pages, :format, :devices, " +
                ":printing, :copying, :translator, :language, :description, :image_url)" +
                "ON DUPLICATE KEY UPDATE bookid = :index;";

        Map<String, Object> properties = new HashMap<>();
        properties.put("index", book.getIndex());
        properties.put("title", book.getTitle());
        properties.put("author", book.getAuthor());
        properties.put("publisher", book.getPublisher());
        properties.put("year", book.getYear());
        properties.put("pages", book.getPages());
        properties.put("format", book.getFormat());
        properties.put("devices", book.getDevices());
        properties.put("printing", book.getPrinting());
        properties.put("copying", book.getCopying());
        properties.put("translator", book.getTranslator());
        properties.put("language", book.getLanguage());
        properties.put("description", book.getDescription());
        properties.put("image_url", book.getImgUrl());

        jdbcOperations.update(INSERT_BOOK, properties);
    }

    private void insertIntoBooksCategories(Book book) {
        final String INSERT_INTO_BOOK_CATEGORY = "INSERT INTO books_categories(bookid, category) " +
                "VALUES (:index, :category);";

        Map<String, Object> params = new HashMap<>();
        params.put("index", book.getIndex());
        params.put("category", book.getCategory());

        jdbcOperations.update(INSERT_INTO_BOOK_CATEGORY, params);
    }

    public void insertIntoCategories(String category, String empik_url) {
        final String INSERT_INTO_KATEGORIE = "INSERT INTO categories(category, empik_url)" +
                "VALUES (:category, :url);";

        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("empik_url", empik_url);

        jdbcOperations.update(INSERT_INTO_KATEGORIE, params);
    }

    public Book findBook(int index) {
        final String SELECT_BY_ID = "SELECT * FROM books WHERE bookid = :index";
        Map<String, Object> params = new HashMap<>();
        params.put("index", index);
        return jdbcOperations.queryForObject(SELECT_BY_ID, params, this::mapBook);
    }

    public List<Book> findBooks(String booksCategory, int booksLimit, int booksOffset) {
        final String SELECT_BY_CATEGORY = "SELECT * " +
                "FROM books " +
                "JOIN books_categories USING(bookid) " +
                "JOIN categories USING(category) " +
                "WHERE category = :category " +
                "LIMIT :booksLimit " +
                "OFFSET :booksOffset;";

        Map<String, Object> params = new HashMap<>();
        params.put("category", booksCategory);
        params.put("booksLimit", booksLimit);
        params.put("booksOffset", booksOffset);
        return jdbcOperations.query(SELECT_BY_CATEGORY, params, this::mapBook);
    }

    public List<String> retrieveCategoriesNames() {
        List<Map<String, Object>> categories = retrieveCategories();
        List<java.lang.String> result = new ArrayList<>();
        for (Map<String, Object> category : categories) {
            result.add((String)category.get("category"));
        }
        return result;
    }

    private List<Map<String, Object>> retrieveCategories() {
        final String SELECT_FROM_CATEGORIES = "SELECT * FROM categories;";
        return jdbcOperations.queryForList(SELECT_FROM_CATEGORIES, new HashMap<>());
    }

    private Book mapBook(ResultSet rs, int rowNum) throws SQLException {
        return new Book.Builder()
                .index(rs.getInt("bookid"))
                .title(rs.getString("title"))
                .author(rs.getString("author"))
                .publisher(rs.getString("publisher"))
                .year(rs.getInt("release_year"))
                .pages(rs.getInt("pages"))
                .format(rs.getString("book_format"))
                .devices(rs.getString("devices"))
                .printing(rs.getString("printing"))
                .copying(rs.getString("copying"))
                .translator(rs.getString("translator"))
                .language(rs.getString("book_language"))
                .description(rs.getString("description"))
                .category(rs.getString("category"))
                .imgUrl(rs.getString("image_url"))
                .build();
    }

    public int findNumberOfBooksByCategory(String booksCategory) {
        final String NUMBER_OF_BOOKS = "SELECT COUNT(*) " +
                "FROM books " +
                "NATURAL JOIN books_categories " +
                "WHERE category = :booksCategory;";

        Map<String, Object> params = new HashMap<>();
        params.put("booksCategory", booksCategory);
        return jdbcOperations.queryForObject(
                NUMBER_OF_BOOKS,
                params,
                (resultSet, rowNumber) -> resultSet.getInt("COUNT(*)")
        );
    }
}
