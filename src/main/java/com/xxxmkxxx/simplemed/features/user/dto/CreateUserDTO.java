package com.xxxmkxxx.simplemed.features.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CreateUserDTO {
    private String userLogin;
    private String userPassword;
    private String userMail;
    private String userPhone;
    private String userName;
    private String userSurname;
    private String userPatronymic;
    private LocalDateTime userDateOfBirth;
}
