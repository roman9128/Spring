package rt.hw5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rt.hw5.model.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
