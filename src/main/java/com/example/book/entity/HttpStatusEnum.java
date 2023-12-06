package com.example.book.entity;

import lombok.Getter;

@Getter
public enum HttpStatusEnum {

    OK(200, "OK");

    private final Integer statusCode;
    private final String message;

    HttpStatusEnum(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
