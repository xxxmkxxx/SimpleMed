package com.xxxmkxxx.simplemed.features.user.repositories;

import com.xxxmkxxx.simplemed.features.user.common.Professions;
import com.xxxmkxxx.simplemed.features.user.models.MedicalStaffModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalStaffRepository extends JpaRepository<MedicalStaffModel, Integer> {
    MedicalStaffModel getMedicalStaffModelByUser_Credence_Login(String login);
    List<MedicalStaffModel> getAllByProfession(Professions profession);
}
