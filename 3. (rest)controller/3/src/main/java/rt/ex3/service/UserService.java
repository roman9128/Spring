package rt.ex3.service;

import org.springframework.stereotype.Service;
import rt.ex3.domain.User;

import java.time.LocalDate;

@Service
public class UserService {

    private final NotifSevice notifSevice;

    public UserService(NotifSevice notifSevice) {
        this.notifSevice = notifSevice;
    }

    public User createUser(String name, String familyName, int birthYear, int birthMonth, int birthDay, long phoneNumber) {
        User user = new User();
        user.setName(name);
        user.setFamilyName(familyName);
        user.setBirthDate(birthYear, birthMonth, birthDay);
        user.setPhoneNumber(phoneNumber);
        notifSevice.notifyUser(user);
        return user;
    }
}
