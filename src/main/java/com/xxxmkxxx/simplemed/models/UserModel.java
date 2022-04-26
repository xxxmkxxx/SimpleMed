package com.xxxmkxxx.simplemed.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private int userId;
    private String name;
    private String surname;
    private String patronymic;
    private Date dateOfBirth;
}
