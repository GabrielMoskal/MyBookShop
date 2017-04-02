package app.data;

import app.web.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gabriel on 20.03.2017.
 */
@Repository
public class JdbcUsersRepository implements UsersRepository {

    private NamedParameterJdbcOperations jdbcOperations;
    private PasswordEncoder passwordEncoder;

    private enum Group {USER(1L);
        long id;

        Group(long id) {
            this.id = id;
        }

        long getId() {
            return this.id;
        }
    }

    @Autowired
    public JdbcUsersRepository(NamedParameterJdbcOperations jdbcOperations,
                               PasswordEncoder passwordEncoder) {
        this.jdbcOperations = jdbcOperations;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User user) {
        Group userGroup = Group.USER;
        insertIntoUsers(user.getUsername(), user.getPassword(), true);
        insertIntoUserDetails(user.getUsername(), user.getFirstName(),
                              user.getLastName(), user.getEmail());
        insertIntoGroupMembers(user.getUsername(), userGroup.getId());
        insertIntoAuthorities(user.getUsername(), userGroup.name());
        return user;
    }

    private void insertIntoUsers(String username, String password, boolean enabled) {
        final String INSERT_USER = "INSERT INTO users " +
                "(username, password, enabled) " +
                "VALUES (:username, :password, :enabled);";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("password", passwordEncoder.encode(password));
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

    private void insertIntoGroupMembers(String username, long id) {
        final String INSERT_GROUP_MEMBER = "INSERT INTO group_members(group_id, username)" +
                "VALUES (:group_id, :username);";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("group_id", id);
        parameters.put("username", username);
        jdbcOperations.update(INSERT_GROUP_MEMBER, parameters);
    }

    private void insertIntoAuthorities(String username, String authority) {
        final String INSERT_AUTHORITY = "INSERT INTO authorities(username, authority)" +
                "VALUES (:username, :authority);";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("authority", authority);
        jdbcOperations.update(INSERT_AUTHORITY, parameters);
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
