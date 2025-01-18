package rt.task2.service;

import org.springframework.stereotype.Service;
import rt.task2.model.Book;
import rt.task2.repo.BookRepo;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepo repo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return repo.findById(id);
    }

    public Book createBook(Book book) {
        return repo.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Optional<Book> optionalBook = repo.findById(id);
        if (optionalBook.isPresent()) {
            Book newBook = optionalBook.get();
            newBook.setTitle(book.getTitle());
            newBook.setTitle(book.getTitle());
            newBook.setAuthor(book.getAuthor());
            newBook.setYearpubl(book.getYearpubl());
            return repo.save(newBook);
        } else {
            throw new IllegalArgumentException("book not found");
        }
    }

    public void removeBook(Long id) {
        repo.deleteById(id);
    }

    public Book getBookByTitle(String title) {
        return repo.findByTitle(title);
    }
}