package com.example.book.dto.request;

import com.example.book.entity.Book;
import com.example.book.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestBorrowDto {

    private String username;
}
