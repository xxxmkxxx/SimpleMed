package com.xxxmkxxx.simplemed.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class CreateUserDAO implements DAO {
    private String userLogin;
    private String userPassword;
    private String userMail;
    private String userPhone;
    private String userName;
    private String userSurname;
    private String userPatronymic;
    private LocalDateTime userDateOfBirth;
}
