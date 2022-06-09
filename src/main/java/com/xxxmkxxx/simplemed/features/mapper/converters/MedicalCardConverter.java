package com.xxxmkxxx.simplemed.features.mapper.converters;

import com.xxxmkxxx.simplemed.features.mapper.ModelConverterManager;
import com.xxxmkxxx.simplemed.features.registry.dto.MedicalCardDTO;
import com.xxxmkxxx.simplemed.features.registry.dto.MedicalCardRecordDTO;
import com.xxxmkxxx.simplemed.features.registry.models.MedicalCardEntryModel;

import java.util.ArrayList;
import java.util.List;

public record MedicalCardConverter(List<MedicalCardEntryModel> records) implements Converter<MedicalCardDTO> {
    @Override
    public MedicalCardDTO convert() {
        return MedicalCardDTO.builder()
                .cardRecords(convertList())
                .build();
    }

    private List<MedicalCardRecordDTO> convertList() {
        List<MedicalCardRecordDTO> dtoRecords = new ArrayList<>();

        for (MedicalCardEntryModel record : records) {
            dtoRecords.add(
                    new ModelConverterManager<>(new MedicalCardEntryConverter(record)).createDTO()
            );
        }

        return dtoRecords;
    }
}
