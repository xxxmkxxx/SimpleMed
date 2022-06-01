package com.xxxmkxxx.simplemed.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class CreateUserRequest {
    private String userLogin;
    private String userPassword;
    private String userMail;
    private String userPhone;
    private String userName;
    private String userSurname;
    private String userPatronymic;
    private LocalDateTime userDateOfBirth;
}
