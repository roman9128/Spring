package rt.ex2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rt.ex2.model.BookReader;
import rt.ex2.repo.BookReaderRepo;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/readers")
public class BookReaderController {

    private BookReaderRepo bookReaderRepo;

    @GetMapping("/all")
    public List<BookReader> getAllReaders() {
        return bookReaderRepo.findAll();
    }

    @GetMapping("/{id}")
    public BookReader getReaderById(@PathVariable Long id) {
        return bookReaderRepo.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public BookReader addReader(@RequestBody BookReader reader) {
        return bookReaderRepo.save(reader);
    }

    @DeleteMapping("/{id}")
    public String deleteReader(@PathVariable Long id) {
        bookReaderRepo.deleteById(id);
        return "OK";
    }


}
