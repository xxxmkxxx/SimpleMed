package com.xxxmkxxx.simplemed.services;

import com.xxxmkxxx.simplemed.models.RoleModel;
import com.xxxmkxxx.simplemed.models.UserModel;
import com.xxxmkxxx.simplemed.repositories.UserRepository;
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

    private List<GrantedAuthority> mapAuthority(List<RoleModel> roles) {
        return roles.stream().map(roleModel -> new SimpleGrantedAuthority(roleModel.getRole().name())).collect(Collectors.toList());
    }
}
