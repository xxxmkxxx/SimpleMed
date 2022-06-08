package com.xxxmkxxx.simplemed.features.mapper.converters;

import com.xxxmkxxx.simplemed.features.mapper.ModelConverterManager;
import com.xxxmkxxx.simplemed.features.registry.dto.MedicalCardDTO;
import com.xxxmkxxx.simplemed.features.registry.dto.MedicalCardRecordDTO;
import com.xxxmkxxx.simplemed.features.registry.models.MedicalCardRecordModel;

import java.util.ArrayList;
import java.util.List;

public record MedicalCardConverter(List<MedicalCardRecordModel> records) implements Converter<MedicalCardDTO> {
    @Override
    public MedicalCardDTO convert() {
        return MedicalCardDTO.builder()
                .cardRecords(convertList())
                .build();
    }

    private List<MedicalCardRecordDTO> convertList() {
        List<MedicalCardRecordDTO> dtoRecords = new ArrayList<>();

        for (MedicalCardRecordModel record : records) {
            dtoRecords.add(
                    new ModelConverterManager<>(new MedicalCardRecordConverter(record)).createDTO()
            );
        }

        return dtoRecords;
    }
}
