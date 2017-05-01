package app.data;

import app.web.dto.UserRegistration;

/**
 * Created by Gabriel on 02.02.2017.
 */
public interface UsersRepository {
    UserRegistration register(UserRegistration user);
    UserRegistration findByUsername(String username);
}
