package com.xxxmkxxx.simplemed.repositories;

import com.xxxmkxxx.simplemed.models.MedicalStaffModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalStaffRepository extends JpaRepository<MedicalStaffModel, Integer> {
    MedicalStaffModel getMedicalStaffModelByUserId(int id);
}
