package com.xxxmkxxx.simplemed.dao;

import com.xxxmkxxx.simplemed.models.MedicalStaffModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BasicMedicInfoDAO implements DAO {
    private String profession;
    LocalTime startWorkTime;
    LocalTime endWorkTime;
    private String description;
    private int experience;

    public BasicMedicInfoDAO(MedicalStaffModel medic) {
        this.profession = medic.getProfession().getName();
        this.startWorkTime = medic.getStartWorkTime();
        this.endWorkTime = medic.getEndWorkTime();
        this.description = medic.getDescription();
        this.experience = medic.getExperience();
    }
}
