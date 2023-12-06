package com.example.book.service;

import com.example.book.dto.BookRegistrationDto;
import com.example.book.dto.ResponseStatusDto;
import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.book.entity.HttpStatusEnum.OK;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    public ResponseStatusDto bookRegistration(BookRegistrationDto bookRegistrationDto) {
        Book book = Book.builder()
                .bookTitle(bookRegistrationDto.getBookTitle())
                .build();

        bookRepository.save(book);

        return ResponseStatusDto.builder()
                .statusCode(OK.getStatusCode())
                .message(OK.getMessage())
                .build();
    }
}
