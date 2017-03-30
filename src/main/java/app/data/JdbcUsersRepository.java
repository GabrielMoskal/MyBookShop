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


    private NamedParameterJdbcOperations jdbcOperations;

    @Autowired
    public JdbcUsersRepository(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public User add(User user) {
        final String INSERT_USER = "INSERT INTO users " +
                "(username, password) " +
                "VALUES (:username, :password);";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", user.getUsername());
        parameters.put("password", user.getPassword());
        jdbcOperations.update(INSERT_USER, parameters);

        final String INSERT_USER_DETAILS = "INSERT INTO user_details " +
                "(username, firstName, lastName, email)" +
                "VALUES (:username, :firstName, :lastName, :email);";

        parameters = new HashMap<>();
        parameters.put("username", user.getUsername());
        parameters.put("firstName", user.getFirstName());
        parameters.put("lastName", user.getLastName());
        parameters.put("email", user.getEmail());
        jdbcOperations.update(INSERT_USER_DETAILS, parameters);

        return user;
    }

    private void insertIntoUsers(String username, String password, boolean enabled) {

    }

    public User findByUsername(String username) {
        final String FIND_USER = "SELECT * FROM USERS " +
                "WHERE username = ?;";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        return jdbcOperations.queryForObject(
                FIND_USER,
                paramMap,
                (resultSet, rowNum) -> {
                    User user = new User();
                    user.setUsername(resultSet.getString("username"));
                    System.out.println(user.getUsername());
                    return user;
                });
    }
}
