package app.data;

import app.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gabriel on 20.03.2017.
 */
@Repository
public class JdbcUsersRepository implements UsersRepository {
    private static final String INSERT_USER = "INSERT INTO users " +
            "(username, password, firstName, lastName, email) " +
            "VALUES (:username, :password, :firstName, :lastName, :email);";

    NamedParameterJdbcOperations jdbcOperations;

    @Autowired
    public JdbcUsersRepository(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public User save(User user) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", user.getUsername());
        parameters.put("password", user.getPassword());
        parameters.put("firstName", user.getFirstName());
        parameters.put("lastName", user.getLastName());
        parameters.put("email", user.getEmail());

        jdbcOperations.update(INSERT_USER, parameters);
        return user;
    }

    public User findByUsername(String username) {
        return null;
    }
}
