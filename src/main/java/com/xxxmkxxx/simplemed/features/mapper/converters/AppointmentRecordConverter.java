package com.xxxmkxxx.simplemed.features.mapper.converters;

import com.xxxmkxxx.simplemed.features.mapper.ModelConverterManager;
import com.xxxmkxxx.simplemed.features.registry.dto.AppointmentRecordDTO;
import com.xxxmkxxx.simplemed.features.registry.models.AppointmentModel;

import java.time.LocalDateTime;

public record AppointmentRecordConverter(AppointmentModel appointment) implements Converter<AppointmentRecordDTO> {
    @Override
    public AppointmentRecordDTO convert() {
        return AppointmentRecordDTO.builder()
                .appointmentStatus(appointment.getAppointmentStatus())
                .dateTime(LocalDateTime.of(appointment.getDate(), appointment.getTime()))
                .medic(new ModelConverterManager<>(new BasicUserInfoConverter(appointment.getMedic())).createDTO())
                .patient(new ModelConverterManager<>(new BasicUserInfoConverter(appointment.getPatient())).createDTO())
                .build();
    }
}
