package com.example.book.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestBookRegistrationDto {

    private String bookTitle;

    private String bookCategory;

    private String bookWriter;

}
