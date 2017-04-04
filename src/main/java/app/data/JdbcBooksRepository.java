package app.data;

import app.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        insertIntoKsiazki(book);
        insertIntoKategorieKsiazki(book);
    }

    private void insertIntoKsiazki(Book book) {
        final String INSERT_BOOK = "INSERT INTO ksiazki (indeks, tytul, autor, wydawnictwo, rok_wydania, " +
                "ilosc_stron, format_ksiazki, liczba_urzadzen, drukowanie, " +
                "kopiowanie, tlumacz, jezyk_wydania, opis)" +
                "VALUES (:index, :title, :author, :publisher, :year, :pages, :format, :devices, " +
                ":printing, :copying, :translator, :language, :description)" +
                "ON DUPLICATE KEY UPDATE indeks = :index;";

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

        jdbcOperations.update(INSERT_BOOK, properties);
    }

    private void insertIntoKategorieKsiazki(Book book) {
        final String INSERT_INTO_KATEGORIE = "INSERT INTO kategoria_ksiazki(indeks, kategoria) " +
                "VALUES (:index, :category);";

        Map<String, Object> params = new HashMap<>();
        params.put("index", book.getIndex());
        params.put("category", book.getCategory());

        jdbcOperations.update(INSERT_INTO_KATEGORIE, params);
    }

    public void insertIntoCategories(String category, String url) {
        final String INSERT_INTO_KATEGORIE = "INSERT INTO kategorie(kategoria, url)" +
                "VALUES (:category, :url);";

        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("url", url);

        jdbcOperations.update(INSERT_INTO_KATEGORIE, params);
    }

    public Book findBook(int index) {
        final String SELECT_BY_ID = "SELECT * FROM ksiazki WHERE indeks = :indeks";
        Map<String, Object> params = new HashMap<>();
        params.put("indeks", index);
        return jdbcOperations.queryForObject(SELECT_BY_ID, params, this::mapBook);
    }

    public List<Book> findBooks(String category) {
        final String SELECT_BY_CATEGORY = "SELECT * " +
                "FROM ksiazki " +
                "JOIN kategoria_ksiazki USING(indeks) " +
                "JOIN kategorie USING(kategoria) " +
                "WHERE kategoria = :category;";

        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        return jdbcOperations.query(SELECT_BY_CATEGORY, params, this::mapBook);
    }

    public List<Map<String, Object>> findCategories() {
        final String SELECT_FROM_CATEGORIES = "SELECT * FROM kategorie;";
        return jdbcOperations.queryForList(SELECT_FROM_CATEGORIES, new HashMap<>());
    }

    private Book mapBook(ResultSet rs, int rowNum) throws SQLException {
        return new Book.Builder()
                .index(rs.getInt("indeks"))
                .title(rs.getString("tytul"))
                .author(rs.getString("autor"))
                .publisher(rs.getString("wydawnictwo"))
                .year(rs.getInt("rok_wydania"))
                .pages(rs.getInt("ilosc_stron"))
                .format(rs.getString("format_ksiazki"))
                .devices(rs.getString("liczba_urzadzen"))
                .printing(rs.getString("drukowanie"))
                .copying(rs.getString("kopiowanie"))
                .translator(rs.getString("tlumacz"))
                .language(rs.getString("jezyk_wydania"))
                .description(rs.getString("opis"))
                .category(rs.getString("kategoria"))
                .build();
    }
}
