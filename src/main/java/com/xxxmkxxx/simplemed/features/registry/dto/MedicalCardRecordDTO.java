package com.xxxmkxxx.simplemed.features.registry.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class MedicalCardRecordDTO {
    private String diseaseName;
    private String description;
    private String medicalComment;
    private String conclusion;
}
