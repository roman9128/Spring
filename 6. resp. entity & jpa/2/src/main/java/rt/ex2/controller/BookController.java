package rt.ex2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rt.ex2.model.Book;
import rt.ex2.model.BookReader;
import rt.ex2.repo.BookReaderRepo;
import rt.ex2.repo.BookRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookRepo bookRepo;
    private final BookReaderRepo bookReaderRepo;

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepo.deleteById(id);
    }

    @PutMapping("/{bookId}/to/{readerId}")
    public ResponseEntity<Book> assignBookToReader(@PathVariable Long bookId,
                                                   @PathVariable Long readerId) {
        Optional<Book> bookOptional = bookRepo.findById(bookId);
        Optional<BookReader> readerOptional = bookReaderRepo.findById(readerId);

        if (bookOptional.isPresent() && readerOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setReader(readerOptional.get());
            bookRepo.save(book);
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}