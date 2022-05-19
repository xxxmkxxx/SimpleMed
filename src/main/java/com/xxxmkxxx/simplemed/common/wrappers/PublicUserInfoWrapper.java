package com.xxxmkxxx.simplemed.common.wrappers;

import com.xxxmkxxx.simplemed.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicUserInfoWrapper implements Wrapper {
    private String name;
    private String surname;
    private String patronymic;

    public PublicUserInfoWrapper(UserModel model) {
        this.name = model.getName();
        this.surname = model.getSurname();
        this.patronymic = model.getPatronymic();
    }
}
