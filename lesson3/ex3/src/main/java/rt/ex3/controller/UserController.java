package rt.ex3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rt.ex3.domain.User;
import rt.ex3.repo.JSONificator;
import rt.ex3.service.RegService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RegService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcService().getRepository().getUsers();
    }

//    @PostMapping("/body")
//    public String userAddFromBody(@RequestBody User user) {
//        service.getDataProcService().getRepository().getUsers().add(user);
//        return "user is added from body";
//    }

    @PostMapping("/add")
    public String userAddFromParam(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) String familyName,
                                   @RequestParam(required = false) int birthYear,
                                   @RequestParam(required = false) int birthMonth,
                                   @RequestParam(required = false) int birthDay,
                                   @RequestParam(required = false) long phoneNumber) {
        service.processRegistration(name, familyName, birthYear, birthMonth, birthDay, phoneNumber);
        saveToJSON();
        return "added new user";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable int id,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String familyName,
                             @RequestParam(required = false) int birthYear,
                             @RequestParam(required = false) int birthMonth,
                             @RequestParam(required = false) int birthDay,
                             @RequestParam(required = false) long phoneNumber) {
        service.updateUserRegInfo(id, name, familyName, birthYear, birthMonth, birthDay, phoneNumber);
        saveToJSON();
        return "updated user with id " + id;
    }

    @DeleteMapping("/remove/{id}")
    public String removeUserByID(@PathVariable int id) {
        service.getDataProcService().removeByID(id);
        saveToJSON();
        return "removed user with id " + id;
    }

    private void saveToJSON() {
        JSONificator.writeToJSON(service.getDataProcService().getRepository().getUsers(), "peopleList");
    }
}
