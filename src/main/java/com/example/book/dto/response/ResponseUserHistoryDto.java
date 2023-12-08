package com.example.book.dto.response;

import com.example.book.entity.BookBorrow;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseUserHistoryDto {

    private Long borrowId;
    private String bookTitle;
    private boolean isReturn;

    public ResponseUserHistoryDto(BookBorrow bookBorrow) {
        this.borrowId = bookBorrow.getId();
        this.isReturn = bookBorrow.isReturn();
        this.bookTitle = bookBorrow.getBook().getBookTitle();
    }
}
