package com.example.book.dto.response;

import com.example.book.entity.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseBookDto {

    private Long bookId;
    private String bookTitle;
    private String bookWriter;
    private String bookCategory;
    private boolean isLoans;

    public ResponseBookDto(Book book) {
        this.bookId = book.getId();
        this.bookTitle = book.getBookTitle();
        this.bookWriter = book.getBookWriter();
        this.bookCategory = book.getBookCategory();
        this.isLoans = book.isLoans();
    }
}
