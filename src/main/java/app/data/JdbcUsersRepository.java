package app.data;

import app.web.dto.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
        private long id;

        Group(long id) {
            this.id = id;
        }

        long getId() {
            return this.id;
        }
    }

    @Autowired
    public JdbcUsersRepository(@Qualifier("jdbcUsers") NamedParameterJdbcOperations jdbcOperations,
                               PasswordEncoder passwordEncoder) {
        this.jdbcOperations = jdbcOperations;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRegistration register(final UserRegistration user) {
        Group userGroup = Group.USER;
        insertIntoUsers(user.getUsername(), user.getPassword().getPassword(), true);
        insertIntoUserDetails(user.getUsername(), user.getFirstName(),
                              user.getLastName(), user.getEmail());
        insertIntoGroupMembers(user.getUsername(), userGroup.getId());
        insertIntoAuthorities(user.getUsername(), userGroup.name());
        return user;
    }

    private void insertIntoUsers(final String username, final String password, boolean enabled) {
        final String INSERT_USER = "INSERT INTO users " +
                "(username, password, enabled) " +
                "VALUES (:username, :password, :enabled);";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("password", passwordEncoder.encode(password));
        parameters.put("enabled", enabled);
        jdbcOperations.update(INSERT_USER, parameters);
    }

    private void insertIntoUserDetails(final String username, final String firstName,
                                       final String lastName, final String email) {
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

    private void insertIntoGroupMembers(final String username, long id) {
        final String INSERT_GROUP_MEMBER = "INSERT INTO group_members(group_id, username)" +
                "VALUES (:group_id, :username);";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("group_id", id);
        parameters.put("username", username);
        jdbcOperations.update(INSERT_GROUP_MEMBER, parameters);
    }

    private void insertIntoAuthorities(final String username, final String authority) {
        final String INSERT_AUTHORITY = "INSERT INTO authorities(username, authority)" +
                "VALUES (:username, :authority);";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("authority", authority);
        jdbcOperations.update(INSERT_AUTHORITY, parameters);
    }

    public UserRegistration findByUsername(final String username) {
        final String FIND_USER = "SELECT * FROM user_details " +
                "WHERE username = :username;";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        return queryForUser(FIND_USER, paramMap);
    }

    private UserRegistration queryForUser(final String query, final Map<String, Object> paramMap) {
        return jdbcOperations.queryForObject(
                query,
                paramMap,
                (resultSet, rowNum) -> {
                    UserRegistration user = new UserRegistration();
                    user.setUsername(resultSet.getString("username"));
                    user.setFirstName(resultSet.getString("firstName"));
                    user.setLastName(resultSet.getString("lastName"));
                    user.setEmail(resultSet.getString("email"));
                    return user;
                });
    }
}
