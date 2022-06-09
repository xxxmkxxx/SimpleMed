package com.xxxmkxxx.simplemed.features.user.services;

import com.xxxmkxxx.simplemed.features.security.models.RoleModel;
import com.xxxmkxxx.simplemed.features.user.models.UserCredenceModel;
import com.xxxmkxxx.simplemed.features.user.repositories.UserCredenceRepository;
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
public class UserCredenceService implements UserDetailsService {
    private final UserCredenceRepository userCredenceRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredenceModel userCredenceModel = userCredenceRepository.getUserCredenceModelByLogin(username);

        if(userCredenceModel == null) {
            throw new UsernameNotFoundException("Not found user with username: " + username);
        }

        return new User(userCredenceModel.getLogin(), userCredenceModel.getPassword(), mapAuthority(userCredenceModel.getUserRoles()));
    }

    private List<GrantedAuthority> mapAuthority(List<RoleModel> roles) {
        return roles.stream().map(roleModel -> new SimpleGrantedAuthority(roleModel.getRole().name())).collect(Collectors.toList());
    }
}
