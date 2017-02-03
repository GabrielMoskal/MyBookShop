package app.data;

import app.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel on 03.02.2017.
 */
@Component
public class MyUsersRepository implements UsersRepository {

    private List<User> usersRepository;

    public MyUsersRepository() {
        usersRepository = new ArrayList<User>();
    }

    public User save(User user) {
        usersRepository.add(user);
        return user;
    }

    public User findByUsername(String username) {
        for (User user : usersRepository) {
            String checkedUsername = user.getUsername();
            if (checkedUsername.equals(username)) {
                return user;
            }
        }
        return null;
    }
}
