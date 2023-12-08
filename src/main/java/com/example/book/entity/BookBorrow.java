package com.example.book.entity;

import com.example.book.util.Timestamped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookBorrow extends Timestamped {

    @Id
    @Column(name = "borrow_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private boolean isReturn = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public BookBorrow(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    public void bookReturn() {
        this.isReturn = true;
    }
}
