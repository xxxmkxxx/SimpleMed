package com.xxxmkxxx.simplemed.features.mapper.converters;

import com.xxxmkxxx.simplemed.features.user.dto.BasicMedicalStaffInfoDTO;
import com.xxxmkxxx.simplemed.features.user.models.MedicalStaffModel;

public record BasicMedicalStaffInfoConverter(MedicalStaffModel medicalStaff) implements Converter<BasicMedicalStaffInfoDTO> {
    @Override
    public BasicMedicalStaffInfoDTO convert() {
        return BasicMedicalStaffInfoDTO.builder()
                .profession(medicalStaff.getProfession().getName())
                .experience(medicalStaff.getExperience())
                .startWorkTime(medicalStaff.getStartWorkTime())
                .endWorkTime(medicalStaff.getEndWorkTime())
                .description(medicalStaff.getDescription())
                .build();
    }
}
