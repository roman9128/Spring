package rt.ex3.service;

import org.springframework.stereotype.Service;
import rt.ex3.domain.User;

@Service
public class NotifSevice {

    public void notifyUser (User user){
        System.out.println("new user. welcome " + user.getName());
    }
}
