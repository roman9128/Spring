package rt.lesson4hw.service;

import org.springframework.stereotype.Service;
import rt.lesson4hw.domain.User;

@Service
public class UserService {

    public User createUser(String name, String familyName, int birthYear, int birthMonth, int birthDay, long phoneNumber) {
        User user = new User();
        user.setName(name);
        user.setFamilyName(familyName);
        user.setBirthYear(birthYear);
        user.setBirthMonth(birthMonth);
        user.setBirthDay(birthDay);
        user.setPhoneNumber(phoneNumber);
        return user;
    }
}