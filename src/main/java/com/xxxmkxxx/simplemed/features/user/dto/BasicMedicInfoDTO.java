package com.xxxmkxxx.simplemed.features.user.dto;

import com.xxxmkxxx.simplemed.common.DTO;
import com.xxxmkxxx.simplemed.features.user.models.MedicalStaffModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BasicMedicInfoDTO implements DTO {
    private String profession;
    LocalTime startWorkTime;
    LocalTime endWorkTime;
    private String description;
    private int experience;

    public BasicMedicInfoDTO(MedicalStaffModel medic) {
        this.profession = medic.getProfession().getName();
        this.startWorkTime = medic.getStartWorkTime();
        this.endWorkTime = medic.getEndWorkTime();
        this.description = medic.getDescription();
        this.experience = medic.getExperience();
    }
}
