package com.xxxmkxxx.simplemed.features.user.repositories;

import com.xxxmkxxx.simplemed.features.user.models.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientModel, Integer> {
    PatientModel getPatientModelByUser_Credence_Login(String login);
}
