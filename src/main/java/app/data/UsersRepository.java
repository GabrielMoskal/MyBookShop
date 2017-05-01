package app.data;

import app.web.dto.UserRegistrationDetails;

/**
 * Created by Gabriel on 02.02.2017.
 */
public interface UsersRepository {
    UserRegistrationDetails register(UserRegistrationDetails user);
    UserRegistrationDetails findByUsername(String username);
}
