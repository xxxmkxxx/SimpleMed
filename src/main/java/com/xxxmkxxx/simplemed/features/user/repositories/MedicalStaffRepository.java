package com.xxxmkxxx.simplemed.features.user.repositories;

import com.xxxmkxxx.simplemed.common.Professions;
import com.xxxmkxxx.simplemed.models.MedicalStaffModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalStaffRepository extends JpaRepository<MedicalStaffModel, Integer> {
    MedicalStaffModel getMedicalStaffModelByUserId(int id);
    List<MedicalStaffModel> getAllByProfession(Professions profession);
}
