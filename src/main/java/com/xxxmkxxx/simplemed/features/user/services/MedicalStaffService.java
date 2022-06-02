package com.xxxmkxxx.simplemed.features.user.services;

import com.xxxmkxxx.simplemed.common.Professions;
import com.xxxmkxxx.simplemed.models.MedicalStaffModel;
import com.xxxmkxxx.simplemed.features.user.repositories.MedicalStaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record MedicalStaffService(MedicalStaffRepository medicalStaffRepository) {
    public MedicalStaffModel getMedic(int medicId) {
        return medicalStaffRepository.getMedicalStaffModelByUserId(medicId);
    }

    public MedicalStaffModel getMedic(String login) {
        return medicalStaffRepository.getMedicalStaffModelByLogin(login);
    }

    public List<MedicalStaffModel> getMedics(Professions profession) {
        return medicalStaffRepository.getAllByProfession(profession);
    }
}
