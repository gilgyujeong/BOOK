package com.example.book.repository;

import com.example.book.entity.BookBorrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookBorrowRepository extends JpaRepository<BookBorrow, Long> {

//    @Query("SELECT b FROM BookBorrow b WHERE b.book.id = :bookId")
    List<BookBorrow> findAllByBookId(Long bookId);

    @Query("SELECT b FROM BookBorrow b WHERE b.isReturn = false AND b.book.id = :bookId")
    BookBorrow findByIsReturnBook(Long bookId);

    List<BookBorrow> findAllByUserId(Long userId);
}
