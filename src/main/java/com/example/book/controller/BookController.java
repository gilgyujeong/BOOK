package com.example.book.controller;

import com.example.book.dto.BookRegistrationDto;
import com.example.book.dto.ResponseStatusDto;
import com.example.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/registration")
    public ResponseStatusDto bookRegistration(@RequestBody BookRegistrationDto bookRegistrationDto) {
        return bookService.bookRegistration(bookRegistrationDto);
    }
}
