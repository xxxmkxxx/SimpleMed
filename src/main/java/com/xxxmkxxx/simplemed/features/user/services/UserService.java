package com.xxxmkxxx.simplemed.features.user.services;

import com.xxxmkxxx.simplemed.common.Message;
import com.xxxmkxxx.simplemed.features.user.dto.CreateUserDTO;
import com.xxxmkxxx.simplemed.features.user.models.UserModel;
import com.xxxmkxxx.simplemed.features.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public record UserService(UserRepository userRepository) {
    public UserModel getUserByLogin(String login) {
        return userRepository.getUserModelByCredence_Login(login);
    }

    public Message createUser(CreateUserDTO userRequest) {
        if (isUserExit(userRequest.getUserLogin(), userRequest.getUserMail())) {
            return new Message("Пользователь с таким логином или почтой уже существует!", Message.MessageType.ERROR);
        } else if (!isDataCorrect()) {
            return new Message("Введённые данные некорректны!", Message.MessageType.ERROR);
        }

        return new Message("Вы успешно зарегистрированы!", Message.MessageType.SUCCESS);
    }

    private boolean isUserExit(String login, String mail) {
        return false;
    }

    private boolean isDataCorrect() {
        return true;
    }
}
