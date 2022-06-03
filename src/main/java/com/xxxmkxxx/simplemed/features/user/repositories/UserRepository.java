package com.xxxmkxxx.simplemed.features.user.repositories;

import com.xxxmkxxx.simplemed.features.user.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    UserModel getUserModelByLogin(String userName);
}
