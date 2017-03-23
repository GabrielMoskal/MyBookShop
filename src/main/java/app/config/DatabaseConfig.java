package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by Gabriel on 20.03.2017.
 */
@Configuration
public class DatabaseConfig {
    private final String DATASOURCE_OBJECT = "java:comp/env/jdbc/MyProject";

    @Bean
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

    /*
    @Bean
    public JdbcOperations jdbcOperations(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource).getJdbcOperations();
    }
    */

    @Bean
    public NamedParameterJdbcOperations jdbcOperations(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
