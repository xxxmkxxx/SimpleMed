package com.xxxmkxxx.simplemed.repositories;

import com.xxxmkxxx.simplemed.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserModel, Integer> {
    UserModel getUserModelByUserId(int userId);
}
