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

    public Book retrieveBook(long index) {
        final String SELECT_BY_ID = "SELECT * FROM books " +
                "NATURAL JOIN books_categories " +
                "WHERE bookid = :index";
        Map<String, Object> params = new HashMap<>();
        params.put("index", index);
        return jdbcOperations.queryForObject(SELECT_BY_ID, params, this::mapBook);
    }

    private Book mapBook(ResultSet rs, int rowNum) throws SQLException {
        return new Book.Builder()
                .index(rs.getLong("bookid"))
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

    public List<Book> retrieveBooks(String booksCategory, int booksLimit, int booksOffset) {
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

    public List<Book> retrieveNewBooks(int booksLimit, int booksOffset) {
        final String SELECT_NEW_BOOKS = "SELECT * " +
                "FROM books " +
                "NATURAL JOIN new_books " +
                "JOIN books_categories USING(bookid) " +
                "LIMIT :booksLimit " +
                "OFFSET :booksOffset;";

        Map<String, Object> params = new HashMap<>();
        params.put("booksLimit", booksLimit);
        params.put("booksOffset", booksOffset);
        return jdbcOperations.query(SELECT_NEW_BOOKS, params, this::mapBook);
    }

    public List<String> retrieveCategoriesNames() {
        List<String> result = new ArrayList<>();
        List<Map<String, Object>> categories = retrieveCategories();
        categories.forEach(rowToValue -> result.add((String)rowToValue.get("category")));
        return result;
    }

    private List<Map<String, Object>> retrieveCategories() {
        final String SELECT_FROM_CATEGORIES = "SELECT * FROM categories;";
        return jdbcOperations.queryForList(SELECT_FROM_CATEGORIES, new HashMap<>());
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
