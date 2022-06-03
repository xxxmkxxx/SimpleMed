package com.xxxmkxxx.simplemed.features.user.dto;

import com.xxxmkxxx.simplemed.common.DTO;
import com.xxxmkxxx.simplemed.features.user.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicUserInfoDTO implements DTO {
    private String name;
    private String surname;
    private String patronymic;

    public PublicUserInfoDTO(UserModel model) {
        this.name = model.getName();
        this.surname = model.getSurname();
        this.patronymic = model.getPatronymic();
    }
}
