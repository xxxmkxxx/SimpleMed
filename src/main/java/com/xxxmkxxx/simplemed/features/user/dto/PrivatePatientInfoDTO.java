package com.xxxmkxxx.simplemed.features.user.dto;

import com.xxxmkxxx.simplemed.common.DTO;
import com.xxxmkxxx.simplemed.features.user.models.PatientModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrivatePatientInfoDTO implements DTO {
    private double height;
    private double weight;
    private String phoneNumber;

    public PrivatePatientInfoDTO(PatientModel model) {
        this.height = 0;
        this.weight = 0;
        this.phoneNumber = model.getDateOfBirth().toString();
    }
}
