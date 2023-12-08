package com.example.book.dto.response;

import com.example.book.entity.BookBorrow;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseHistoryDto {

    private Long borrowId;
    private String username;
    private String bookTitle;
    private boolean isReturn;

    public ResponseHistoryDto(BookBorrow bookBorrow) {
        this.borrowId = bookBorrow.getId();
        this.username = bookBorrow.getUser().getUsername();
        this.bookTitle = bookBorrow.getBook().getBookTitle();
        this.isReturn = bookBorrow.isReturn();
    }
}
