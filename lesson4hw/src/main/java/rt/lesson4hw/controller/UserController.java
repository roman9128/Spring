package rt.lesson4hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rt.lesson4hw.domain.User;
import rt.lesson4hw.repo.JSONificator;
import rt.lesson4hw.service.RegService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private RegService service;

    @GetMapping("/users")
    public String userList(Model model) {
        model.addAttribute("users", service.getDataProcService().getRepository().getUsers());
        return "users";
    }

    @PostMapping("/users")
    public String addUser(User user, Model model) {
        service.getDataProcService().addNew(user);
        model.addAttribute("users", service.getDataProcService().getRepository().getUsers());
        saveToJSON();
        return "users";
    }

    @GetMapping("/user-delete/{id}")
    public String removeUserByID(@PathVariable int id) {
        service.removeUserWithID(id);
        saveToJSON();
        return "redirect:/users";
    }

    private void saveToJSON() {
        JSONificator.writeToJSON(service.getDataProcService().getRepository().getUsers());
    }
}
