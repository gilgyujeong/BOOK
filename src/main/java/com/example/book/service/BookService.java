package com.example.book.service;

import com.example.book.dto.BookRegistrationDto;
import com.example.book.dto.ResponseStatusDto;
import org.springframework.stereotype.Service;

import static com.example.book.entity.HttpStatusEnum.OK;

@Service
public class BookService {
    public ResponseStatusDto bookRegistration(BookRegistrationDto bookRegistrationDto) {
        return ResponseStatusDto.builder()
                .statusCode(OK.getStatusCode())
                .message(OK.getMessage())
                .build();
    }
}
