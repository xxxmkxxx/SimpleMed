package com.xxxmkxxx.simplemed.features.registry.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class MedicalCardDTO {
    private List<MedicalCardRecordDTO> cardRecords;
}
