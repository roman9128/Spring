package rt.ex2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rt.ex2.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
}
