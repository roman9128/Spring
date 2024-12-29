package rt.hw5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rt.hw5.model.Person;
import rt.hw5.repo.PersonRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepo repo;

    public List<Person> getAllPeople() {
        return repo.findAll();
    }

    public Person getPersonById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void createPerson(String name, String familyName, int birthYear, int birthMonth, int birthDay) {
        Person person = new Person();
        person.setName(name);
        person.setFamilyName(familyName);
        person.setBirthYear(birthYear);
        person.setBirthMonth(birthMonth);
        person.setBirthDay(birthDay);
        repo.save(person);
    }

    public void updatePerson(Long id, String name, String familyName, Integer birthYear, Integer birthMonth, Integer birthDay) {
        Optional<Person> optionalPerson = repo.findById(id);
        if (optionalPerson.isPresent()) {
            Person editedPerson = optionalPerson.get();
            if (name != null) editedPerson.setName(name);
            if (familyName != null) editedPerson.setFamilyName(familyName);
            if (birthYear != null) editedPerson.setBirthYear(birthYear);
            if (birthMonth != null) editedPerson.setBirthMonth(birthMonth);
            if (birthDay != null) editedPerson.setBirthDay(birthDay);
            repo.save(editedPerson);
        } else {
            throw new IllegalArgumentException("person not found");
        }
    }

    public void removePerson(Long id) {
        repo.deleteById(id);
    }
}