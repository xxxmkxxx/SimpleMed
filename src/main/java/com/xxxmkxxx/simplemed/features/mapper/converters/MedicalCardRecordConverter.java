package com.xxxmkxxx.simplemed.features.mapper.converters;

import com.xxxmkxxx.simplemed.features.registry.dto.MedicalCardRecordDTO;
import com.xxxmkxxx.simplemed.features.registry.models.MedicalCardRecordModel;

public record MedicalCardRecordConverter(MedicalCardRecordModel medicalCardRecord) implements Converter<MedicalCardRecordDTO> {
    @Override
    public MedicalCardRecordDTO convert() {
        return MedicalCardRecordDTO.builder()
                .diseaseName(medicalCardRecord.getDiseaseName())
                .medicalComment(medicalCardRecord.getMedicalComment())
                .description(medicalCardRecord.getDescription())
                .conclusion(medicalCardRecord.getConclusion())
                .build();
    }
}
