package com.example.book.dto.request;

import com.example.book.entity.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestSignupDto {

    private String username;
    private String password;
    private String checkPassword;
}
