package com.example.book.dto.response;

import com.example.book.entity.BookBorrow;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseBookHistoryDto {
    private Long borrowId;
    private boolean isReturn;
    private String username;

    public ResponseBookHistoryDto(BookBorrow bookBorrow) {
        this.borrowId = bookBorrow.getId();
        this.isReturn = bookBorrow.isReturn();
        this.username = bookBorrow.getUser().getUsername();
    }
}
