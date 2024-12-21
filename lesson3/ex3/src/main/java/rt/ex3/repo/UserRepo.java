package rt.ex3.repo;

import org.springframework.stereotype.Component;
import rt.ex3.domain.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepo {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }
}
