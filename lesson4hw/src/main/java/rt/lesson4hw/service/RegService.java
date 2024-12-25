package rt.lesson4hw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegService {
    @Autowired
    private UserService userService;
    @Autowired
    private DataProcService dataProcService;

    public void processRegistration(String name, String familyName, int birthYear, int birthMonth, int birthDay, long phoneNumber) {
        dataProcService.addNew(userService.createUser(name, familyName, birthYear, birthMonth, birthDay, phoneNumber));
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

}
