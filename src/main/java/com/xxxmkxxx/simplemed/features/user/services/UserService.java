package com.xxxmkxxx.simplemed.features.user.services;

import com.xxxmkxxx.simplemed.common.Message;
import com.xxxmkxxx.simplemed.models.RoleModel;
import com.xxxmkxxx.simplemed.models.UserModel;
import com.xxxmkxxx.simplemed.features.user.repositories.UserRepository;
import com.xxxmkxxx.simplemed.requests.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.getUserModelByLogin(username);

        if(userModel == null) {
            throw new UsernameNotFoundException("Not found user with username: " + username);
        }

        return new User(userModel.getLogin(), userModel.getPassword(), mapAuthority(userModel.getUserRoles()));
    }

    public Message createUser(CreateUserRequest userRequest) {
        if (isUserExit(userRequest.getUserLogin(), userRequest.getUserMail())) {
            return new Message("Пользователь с таким логином или почтой уже существует!", Message.MessageType.ERROR);
        } else if (!isDataCorrect()) {
            return new Message("Введённые данные некорректны!", Message.MessageType.ERROR);
        }

        UserModel user = UserModel.builder()
                .login(userRequest.getUserLogin())
                .password(userRequest.getUserPassword())
                .mail(userRequest.getUserMail())
                .dateOfBirth(userRequest.getUserDateOfBirth())
                .name(userRequest.getUserName())
                .surname(userRequest.getUserSurname())
                .patronymic(userRequest.getUserPatronymic())
                .phoneNumber(userRequest.getUserPhone())
                .build();

        return new Message("Вы успешно зарегистрированы!", Message.MessageType.SUCCESS);
    }

    private boolean isUserExit(String login, String mail) {
        return false;
    }

    private boolean isDataCorrect() {
        return true;
    }

    private List<GrantedAuthority> mapAuthority(List<RoleModel> roles) {
        return roles.stream().map(roleModel -> new SimpleGrantedAuthority(roleModel.getRole().name())).collect(Collectors.toList());
    }
}
