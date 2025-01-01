package rt.ex2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rt.ex2.model.BookReader;

@Repository
public interface BookReaderRepo extends JpaRepository<BookReader, Long> {
}
