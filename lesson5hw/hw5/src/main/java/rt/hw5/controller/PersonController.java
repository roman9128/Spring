package rt.hw5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rt.hw5.model.Person;
import rt.hw5.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping("/add")
    public String addNewPerson(@RequestParam(required = false) String name,
                             @RequestParam(required = false) String familyName,
                             @RequestParam(required = false) Integer birthYear,
                             @RequestParam(required = false) Integer birthMonth,
                             @RequestParam(required = false) Integer birthDay) {
        service.createPerson(name, familyName, birthYear, birthMonth, birthDay);
        return "successfully added";
    }

    @GetMapping("/all")
    public List<Person> getAllPeople() {
        return service.getAllPeople();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id){
        return service.getPersonById(id);
    }

    @PutMapping("/update/{id}")
    public String updatePerson(@PathVariable Long id,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) String familyName,
                             @RequestParam(required = false) Integer birthYear,
                             @RequestParam(required = false) Integer birthMonth,
                             @RequestParam(required = false) Integer birthDay) {
        service.updatePerson(id, name, familyName, birthYear, birthMonth, birthDay);
        return "successfully updated";
    }

    @DeleteMapping("/remove/{id}")
    public String removePersonByID(@PathVariable Long id) {
        service.removePerson(id);
        return "successfully removed";
    }
}