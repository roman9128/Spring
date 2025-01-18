package rt.ex3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rt.ex3.domain.User;
import rt.ex3.repo.UserRepo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcService {

    @Autowired
    private UserRepo repository;

    public void addNew(User user) {
        repository.getUsers().add(user);
    }

    public UserRepo getRepository() {
        return repository;
    }

    public User getByID(int id) {
        return repository.getUsers()
                .stream()
                .filter(u -> u.getId() == id)
                .findFirst().orElse(null);
    }

    public List<User> sortByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getCurrentAge))
                .collect(Collectors.toList());
    }

    public List<User> sortByName(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
    }

    public List<User> filterByFamilyName(List<User> users, String familyName) {
        return users.stream()
                .filter(u -> u.getFamilyName().equals(familyName))
                .collect(Collectors.toList());
    }

    public List<User> filterByOlderAge(List<User> users, int age) {
        return users.stream()
                .filter(u -> u.getCurrentAge() >= age)
                .collect(Collectors.toList());
    }

    public List<User> findByPhoneNumber(List<User> users, long phNumber) {
        return users.stream()
                .filter(u -> u.getPhoneNumber() == phNumber)
                .collect(Collectors.toList());
    }

    public void updateUserInfo(int id, String name, String familyName, int birthYear, int birthMonth, int birthDay, long phoneNumber){
        User user = getByID(id);
        user.setName(name);
        user.setFamilyName(familyName);
        user.setBirthDate(birthYear, birthMonth, birthDay);
        user.setPhoneNumber(phoneNumber);
    }

    public void removeByID(int id) {
        repository.getUsers().remove(getByID(id));
    }
}
