package com.xxxmkxxx.simplemed.dao;

import com.xxxmkxxx.simplemed.models.PatientModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrivatePatientInfoDAO implements DAO {
    private double height;
    private double weight;
    private String phoneNumber;

    public PrivatePatientInfoDAO(PatientModel model) {
        this.height = 0;
        this.weight = 0;
        this.phoneNumber = model.getDateOfBirth().toString();
    }
}
