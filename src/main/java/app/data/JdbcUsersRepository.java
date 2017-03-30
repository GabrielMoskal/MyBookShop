package app.data;

import app.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gabriel on 20.03.2017.
 */
@Repository
public class JdbcUsersRepository implements UsersRepository {

    private NamedParameterJdbcOperations jdbcOperations;

    @Autowired
    public JdbcUsersRepository(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public User add(User user) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(user.getPassword());
        insertIntoUsers(user.getUsername(), encryptedPassword, true);
        insertIntoUserDetails(user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail());
        return user;
    }

    private void insertIntoUsers(String username, String password, boolean enabled) {
        final String INSERT_USER = "INSERT INTO users " +
                "(username, password, enabled) " +
                "VALUES (:username, :password, :enabled);";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("password", password);
        parameters.put("enabled", enabled);
        jdbcOperations.update(INSERT_USER, parameters);
    }

    private void insertIntoUserDetails(String username, String firstName, String lastName, String email) {
        final String INSERT_USER_DETAILS = "INSERT INTO user_details " +
                "(username, firstName, lastName, email)" +
                "VALUES (:username, :firstName, :lastName, :email);";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("firstName", firstName);
        parameters.put("lastName", lastName);
        parameters.put("email", email);
        jdbcOperations.update(INSERT_USER_DETAILS, parameters);
    }

    public User findByUsername(String username) {
        final String FIND_USER = "SELECT * FROM users " +
                "WHERE username = :username;";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        return jdbcOperations.queryForObject(
                FIND_USER,
                paramMap,
                (resultSet, rowNum) -> {
                    User user = new User();
                    user.setUsername(resultSet.getString("username"));
                    return user;
                });
    }
}
