package com.example.book.entity;

import com.example.book.dto.request.RequestBookRegistrationDto;
import com.example.book.util.Timestamped;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book extends Timestamped {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String bookTitle;

    @Column(nullable = false)
    private String bookCategory;

    @Column(nullable = false)
    String bookWriter;

    @Builder.Default
    @Column
    private boolean isLoans = false;

    @JsonIgnore
    @Builder.Default
    @OneToMany(mappedBy = "book")
    private List<BookBorrow> bookBorrows = new ArrayList<>();

    public void update(RequestBookRegistrationDto requestBookRegistrationDto) {
        this.bookTitle = requestBookRegistrationDto.getBookTitle();
        this.bookCategory = requestBookRegistrationDto.getBookCategory();
        this.bookWriter = requestBookRegistrationDto.getBookWriter();
    }

    public void bookReturn() {
        this.isLoans = false;
    }

    public void bookBorrow() {
        this.isLoans = true;
    }
}
