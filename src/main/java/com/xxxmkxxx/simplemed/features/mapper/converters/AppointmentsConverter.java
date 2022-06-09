package com.xxxmkxxx.simplemed.features.mapper.converters;

import com.xxxmkxxx.simplemed.features.mapper.ModelConverterManager;
import com.xxxmkxxx.simplemed.features.registry.dto.AppointmentRecordDTO;
import com.xxxmkxxx.simplemed.features.registry.dto.AppointmentsDTO;
import com.xxxmkxxx.simplemed.features.registry.models.AppointmentEntryModel;

import java.util.ArrayList;
import java.util.List;

public record AppointmentsConverter(List<AppointmentEntryModel> appointments) implements Converter<AppointmentsDTO> {
    @Override
    public AppointmentsDTO convert() {
        return AppointmentsDTO.builder()
                .records(convertList())
                .build();
    }

    private List<AppointmentRecordDTO> convertList() {
        List<AppointmentRecordDTO> appointmentDTOList = new ArrayList<>();

        for (AppointmentEntryModel appointment : appointments) {
            appointmentDTOList.add(
                    new ModelConverterManager<>(new AppointmentEntryConverter(appointment)).createDTO()
            );
        }

        return appointmentDTOList;
    }
}
