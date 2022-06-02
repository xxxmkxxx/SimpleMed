package com.xxxmkxxx.simplemed.features.user.services;

import com.xxxmkxxx.simplemed.models.PatientModel;
import com.xxxmkxxx.simplemed.features.user.repositories.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public record PatientService(PatientRepository patientRepository) {
    public PatientModel getPatient(int patientId) {
        return patientRepository.getPatientModelByUserId(patientId);
    }
}
