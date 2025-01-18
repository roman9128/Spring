package rt.hw6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rt.hw6.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}