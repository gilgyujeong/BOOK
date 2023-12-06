package com.example.book.controller;

import com.example.book.dto.RequestSignupDto;
import com.example.book.dto.ResponseSignupDto;
import com.example.book.dto.ResponseStatusDto;
import com.example.book.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/singup")
    public ResponseStatusDto signup(@RequestBody RequestSignupDto requestSignupDto) {
        return userService.signup(requestSignupDto);
    }
}
