package com.example.book.controller;

import com.example.book.dto.request.RequestBookRegistrationDto;
import com.example.book.dto.request.RequestBorrowDto;
import com.example.book.dto.response.ResponseDataDto;
import com.example.book.dto.response.ResponseStatusDto;
import com.example.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/registration")
    public ResponseStatusDto bookRegistration(@RequestBody RequestBookRegistrationDto requestBookRegistrationDto) {
        return bookService.bookRegistration(requestBookRegistrationDto);
    }

    @GetMapping("/")
    public ResponseDataDto<?> bookList() {
        return bookService.bookList();
    }

    @PutMapping("/update/{bookId}")
    public ResponseStatusDto bookUpdate(@RequestBody RequestBookRegistrationDto requestBookRegistrationDto, @PathVariable Long bookId) {
        return bookService.bookUpdate(requestBookRegistrationDto, bookId);
    }

    @PostMapping("/borrow/{bookId}")
    public ResponseStatusDto bookBorrow(@PathVariable Long bookId , @RequestBody RequestBorrowDto requestBorrowDto) {
        return bookService.bookBorrow(bookId, requestBorrowDto);
    }

    @GetMapping("/bookHistory/{bookId}")
    public ResponseDataDto<?> bookHistory(@PathVariable Long bookId) {
        return bookService.bookHistory(bookId);
    }

    @GetMapping("/userHistory/{userId}")
    public ResponseDataDto<?> userHistory(@PathVariable Long userId) {
        return bookService.userHistory(userId);
    }

    @GetMapping("/history")
    public ResponseDataDto<?> history() {
        return bookService.history();
    }

    @PutMapping("/return/{bookId}")
    public ResponseStatusDto bookReturn(@PathVariable Long bookId) {
        return bookService.bookReturn(bookId);
    }
}
