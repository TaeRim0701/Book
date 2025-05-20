package likelion.book.Service;

import likelion.book.Dto.BookRequest;
import likelion.book.Dto.BookResponse;
import likelion.book.Entity.Book;
import likelion.book.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Long createBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setPrice(bookRequest.getPrice());

        return bookRepository.save(book).getId();
    }

    public List<BookResponse> findAll() {
        return bookRepository.findAll().stream()
                .map(BookResponse::new)
                .collect(Collectors.toList());
    }

    public BookResponse findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("책이 존재하지 않습니다."));
        return new BookResponse(book);
    }

    public void updateBook(Long id, BookRequest bookRequest) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("책이 존재하지 않습니다."));

        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setPrice(bookRequest.getPrice());
        bookRepository.save(book);
    }


    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
