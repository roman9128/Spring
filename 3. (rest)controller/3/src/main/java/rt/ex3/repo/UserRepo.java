package rt.ex3.repo;

import org.springframework.stereotype.Component;
import rt.ex3.domain.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepo {
    private static final File file = new File("users.json");
    private List<User> users;

    public UserRepo() {
        if (!file.exists()) {
            users = new ArrayList<>();
        } else {
            users = JSONificator.readFromJSON();
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
