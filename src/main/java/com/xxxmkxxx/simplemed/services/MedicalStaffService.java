package com.xxxmkxxx.simplemed.services;

import com.xxxmkxxx.simplemed.models.MedicalStaffModel;
import com.xxxmkxxx.simplemed.repositories.MedicalStaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public record MedicalStaffService(MedicalStaffRepository medicalStaffRepository) {
    public MedicalStaffModel getMedic(int medicId) {
        return medicalStaffRepository.getMedicalStaffModelByUserId(medicId);
    }
}
