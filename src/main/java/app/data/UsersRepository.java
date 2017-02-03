package app.data;

import app.User;

/**
 * Created by Gabriel on 02.02.2017.
 */
public interface UsersRepository {
    User save(User user);

    User findByUsername(String username);
}
