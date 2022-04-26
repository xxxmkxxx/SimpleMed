package com.xxxmkxxx.simplemed.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientModel extends UserModel {
    private int PatientId;
    private MedicalCardModel card;
    private List<AdmissionRecordModel> records;
}
