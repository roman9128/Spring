package rt.task2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rt.task2.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    public Book findByTitle(String title);
}
