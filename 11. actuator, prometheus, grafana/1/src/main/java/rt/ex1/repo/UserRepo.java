package rt.ex1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rt.ex1.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}