package app.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by Gabriel on 04.04.2017.
 */
@Configuration
public class DatabaseBooksConfig {
    private final String DATASOURCE_OBJECT = "java:comp/env/jdbc/BooksApp";

    @Bean(name = "dsBooks")
    public DataSource dataSource() {
        DataSource dataSource = null;
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup(DATASOURCE_OBJECT);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean(name = "jdbcBooks")
    public NamedParameterJdbcOperations jdbcOperations(@Qualifier("dsBooks") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
