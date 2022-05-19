package com.xxxmkxxx.simplemed.repositories;

import com.xxxmkxxx.simplemed.models.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientModel, Integer> {
    PatientModel getPatientModelByUserId(int id);
}
