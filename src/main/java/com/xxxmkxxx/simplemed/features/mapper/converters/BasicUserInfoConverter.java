package com.xxxmkxxx.simplemed.features.mapper.converters;

import com.xxxmkxxx.simplemed.features.user.dto.BasicUserInfoDTO;
import com.xxxmkxxx.simplemed.features.user.models.UserModel;

public record BasicUserInfoConverter(UserModel user) implements Converter<BasicUserInfoDTO> {
    @Override
    public BasicUserInfoDTO convert() {
        return new BasicUserInfoDTO(
                user.getName(),
                user.getSurname(),
                user.getPatronymic()
        );
    }
}
