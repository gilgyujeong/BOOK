package com.example.book.entity;

import lombok.Getter;

@Getter
public enum HttpStatusEnum {

    OK(200, "OK"),
    CREATED(201, "Created"),
    FAIL(401, "Fail"),
    NOT_FOUND(404, "Not Found");

    private final Integer statusCode;
    private final String message;

    HttpStatusEnum(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
