package com.xxxmkxxx.simplemed.features.mapper.converters;

import com.xxxmkxxx.simplemed.features.user.dto.PrivatePatientInfoDTO;
import com.xxxmkxxx.simplemed.features.user.models.PatientModel;

public record PrivatePatientInfoConverter(PatientModel patient) implements Converter<PrivatePatientInfoDTO> {
    @Override
    public PrivatePatientInfoDTO convert() {
        return PrivatePatientInfoDTO.builder()
                .phoneNumber(patient.getUser().getCredence().getPhoneNumber())
                .height(patient.getHeight())
                .weight(patient().getWeight())
                .build();
    }
}
