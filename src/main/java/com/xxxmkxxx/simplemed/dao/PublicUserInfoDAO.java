package com.xxxmkxxx.simplemed.dao;

import com.xxxmkxxx.simplemed.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicUserInfoDAO implements DAO {
    private String name;
    private String surname;
    private String patronymic;

    public PublicUserInfoDAO(UserModel model) {
        this.name = model.getName();
        this.surname = model.getSurname();
        this.patronymic = model.getPatronymic();
    }
}
