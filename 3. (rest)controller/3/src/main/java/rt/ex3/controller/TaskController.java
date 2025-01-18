package rt.ex3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rt.ex3.domain.User;
import rt.ex3.service.DataProcService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private DataProcService dataProcService;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("get user by ID");
        tasks.add("sort users by age");
        tasks.add("sort users by name");
        tasks.add("filter users by family name");
        tasks.add("filter users by older age");
        return tasks;
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable int id) {
        return dataProcService.getByID(id);
    }

    @GetMapping("/sort/age")
    public List<User> sortByAge() {
        return dataProcService.sortByAge(dataProcService.getRepository().getUsers());
    }

    @GetMapping("/sort/name")
    public List<User> sortByName() {
        return dataProcService.sortByName(dataProcService.getRepository().getUsers());
    }

    @GetMapping("/filterfamily/{family}")
    public List<User> filterF(@PathVariable String family) {
        return dataProcService.filterByFamilyName(dataProcService.getRepository().getUsers(), family);
    }

    @GetMapping("/filterage/{age}")
    public List<User> filterA(@PathVariable int age) {
        return dataProcService.filterByOlderAge(dataProcService.getRepository().getUsers(), age);
    }
}
