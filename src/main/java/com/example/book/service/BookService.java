package com.example.book.service;

import com.example.book.dto.request.RequestBookRegistrationDto;
import com.example.book.dto.request.RequestBorrowDto;
import com.example.book.dto.response.*;
import com.example.book.entity.Book;
import com.example.book.entity.BookBorrow;
import com.example.book.entity.User;
import com.example.book.repository.BookBorrowRepository;
import com.example.book.repository.BookRepository;
import com.example.book.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.book.entity.HttpStatusEnum.FAIL;
import static com.example.book.entity.HttpStatusEnum.OK;

@Service
@RequiredArgsConstructor
public class BookService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final BookBorrowRepository bookBorrowRepository;
    public ResponseStatusDto bookRegistration(RequestBookRegistrationDto requestBookRegistrationDto) {
        Book book = Book.builder()
                .bookTitle(requestBookRegistrationDto.getBookTitle())
                .bookCategory((requestBookRegistrationDto.getBookCategory()))
                .bookWriter(requestBookRegistrationDto.getBookWriter())
                .build();

        bookRepository.save(book);

        return ResponseStatusDto.builder()
                .statusCode(OK.getStatusCode())
                .message(OK.getMessage())
                .build();
    }

    @Transactional
    public ResponseStatusDto bookUpdate(RequestBookRegistrationDto requestBookRegistrationDto, Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(()
                -> new IllegalArgumentException("존재하지 않는 책 정보 입니다."));

        book.update(requestBookRegistrationDto);

        return ResponseStatusDto.builder()
                .statusCode(OK.getStatusCode())
                .message(OK.getMessage())
                .build();
    }

    public ResponseDataDto<?> bookHistory(Long bookId) {
        List<BookBorrow> bookBorrows = bookBorrowRepository.findAllByBookId(bookId);
        List<ResponseBookHistoryDto> responseBookHistoryDtoList = bookBorrows.stream().map(ResponseBookHistoryDto::new).toList();
        return new ResponseDataDto<>(responseBookHistoryDtoList);
    }

    public ResponseDataDto<?> userHistory(Long userId) {
        List<BookBorrow> bookBorrows = bookBorrowRepository.findAllByUserId(userId);
        List<ResponseUserHistoryDto> responseUserHistoryDtoList = bookBorrows.stream().map(ResponseUserHistoryDto::new).toList();
        return new ResponseDataDto<>(responseUserHistoryDtoList);
    }

    public ResponseDataDto<?> history() {
        List<BookBorrow> bookBorrowList = bookBorrowRepository.findAll();
        List<ResponseHistoryDto> responseHistoryDtoList = bookBorrowList.stream().map(ResponseHistoryDto::new).toList();
        return new ResponseDataDto<>(responseHistoryDtoList);
    }

    public ResponseStatusDto bookBorrow(Long bookId, RequestBorrowDto requestBorrowDto) {
        User user = userRepository.findByUsername(requestBorrowDto.getUsername()).orElseThrow(()
                -> new IllegalArgumentException("존재하지 않는 유저 입니다."));

        Book book = bookRepository.findById(bookId).orElseThrow(()
                -> new IllegalArgumentException("존재하지 않는 도서 정보 입니다."));

        if (book.isLoans()) {
            return ResponseStatusDto.builder()
                    .statusCode(FAIL.getStatusCode())
                    .message(FAIL.getMessage())
                    .build();
        }
        book.bookBorrow();

        BookBorrow bookBorrow = new BookBorrow(user, book);

        bookBorrowRepository.save(bookBorrow);

        return ResponseStatusDto.builder()
                .statusCode(OK.getStatusCode())
                .message(OK.getMessage())
                .build();
    }

    @Transactional
    public ResponseStatusDto bookReturn(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 책 정보 입니다."));

        BookBorrow bookBorrow = bookBorrowRepository.findByIsReturnBook(bookId);

        book.bookReturn();
        bookBorrow.bookReturn();


        return ResponseStatusDto.builder()
                .statusCode(OK.getStatusCode())
                .message(OK.getMessage())
                .build();
    }
}
