package com.xxxmkxxx.simplemed.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCardModel {
    private String cardId;
    private String diseaseName;
    private String description;
    private String medicalComment;
    private String conclusion;
}
