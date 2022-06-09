package com.xxxmkxxx.simplemed.features.user.repositories;

import com.xxxmkxxx.simplemed.features.user.models.UserCredenceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCredenceRepository extends JpaRepository<UserCredenceModel, Integer> {
    UserCredenceModel getUserCredenceModelByLogin(String login);
}
