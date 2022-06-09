package com.xxxmkxxx.simplemed.features.user.services;

import com.xxxmkxxx.simplemed.features.user.common.Professions;
import com.xxxmkxxx.simplemed.features.user.models.MedicalStaffModel;
import com.xxxmkxxx.simplemed.features.user.repositories.MedicalStaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record MedicalStaffService(MedicalStaffRepository medicalStaffRepository) {
    public MedicalStaffModel getMedic(String login) {
        return medicalStaffRepository.getMedicalStaffModelByUser_Credence_Login(login);
    }

    public List<MedicalStaffModel> getMedics(Professions profession) {
        return medicalStaffRepository.getAllByProfession(profession);
    }
}
