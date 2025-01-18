package rt.lesson4hw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rt.lesson4hw.domain.User;
import rt.lesson4hw.repo.UserRepo;

@Service
public class DataProcService {

    @Autowired
    private UserRepo repository;

    public UserRepo getRepository() {
        return repository;
    }

    public void addNew(User user) {
        repository.getUsers().add(user);
    }

    public User getByID(int id) {
        return repository.getUsers()
                .stream()
                .filter(u -> u.getId() == id)
                .findFirst().orElse(null);
    }

    public void removeByID(int id) {
        repository.getUsers().remove(getByID(id));
    }
}
