package com.xxxmkxxx.simplemed.features.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class PrivatePatientInfoDTO {
    private double height;
    private double weight;
    private String phoneNumber;
}
