package rt.ex3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegService {
    @Autowired
    private NotifSevice notifSevice;
    @Autowired
    private UserService userService;
    @Autowired
    private DataProcService dataProcService;

    public void processRegistration(String name, String familyName, int birthYear, int birthMonth, int birthDay, long phoneNumber) {
        dataProcService.addNew(userService.createUser(name, familyName, birthYear, birthMonth, birthDay, phoneNumber));
    }

    public void updateUserRegInfo(int id, String name, String familyName, int birthYear, int birthMonth, int birthDay, long phoneNumber){
        dataProcService.updateUserInfo(id, name, familyName, birthYear, birthMonth, birthDay, phoneNumber);
    }

    public void removeUserWithID(int id){
        dataProcService.removeByID(id);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public DataProcService getDataProcService() {
        return dataProcService;
    }

    public void setDataProcService(DataProcService dataProcService) {
        this.dataProcService = dataProcService;
    }

    public NotifSevice getNotifSevice() {
        return notifSevice;
    }

    public void setNotifSevice(NotifSevice notifSevice) {
        this.notifSevice = notifSevice;
    }
}
