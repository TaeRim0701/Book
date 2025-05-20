package likelion.book.Dto;

import likelion.book.Entity.Book;
import lombok.Getter;

@Getter
public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private int price;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.price = book.getPrice();
    }
}
