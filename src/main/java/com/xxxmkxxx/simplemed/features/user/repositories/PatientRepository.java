package com.xxxmkxxx.simplemed.features.user.repositories;

import com.xxxmkxxx.simplemed.models.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientModel, Integer> {
    PatientModel getPatientModelByUserId(int id);
    PatientModel getPatientModelByLogin(String login);
}
