package com.xxxmkxxx.simplemed.responses;

import com.xxxmkxxx.simplemed.models.MedicalStaffModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BasicMedicInfoResponse implements Response {
    private String profession;
    LocalTime startWorkTime;
    LocalTime endWorkTime;
    private String description;
    private int experience;

    public BasicMedicInfoResponse(MedicalStaffModel medic) {
        this.profession = medic.getProfession().getName();
        this.startWorkTime = medic.getStartWorkTime();
        this.endWorkTime = medic.getEndWorkTime();
        this.description = medic.getDescription();
        this.experience = medic.getExperience();
    }
}
