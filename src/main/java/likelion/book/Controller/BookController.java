package likelion.book.Controller;

import likelion.book.Dto.BookRequest;
import likelion.book.Dto.BookResponse;
import likelion.book.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public Long createBook(@RequestBody BookRequest bookRequest) {
        return bookService.createBook(bookRequest);
    }

    @GetMapping
    public List<BookResponse> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PutMapping("{id}")
    public void updateBook(
            @PathVariable Long id,
            @RequestBody BookRequest bookRequest) {
        bookService.updateBook(id, bookRequest);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
