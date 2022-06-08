package com.xxxmkxxx.simplemed.features.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Builder
@Getter
@AllArgsConstructor
public class BasicMedicalStaffInfoDTO {
    private String profession;
    private LocalTime startWorkTime;
    private LocalTime endWorkTime;
    private String description;
    private int experience;
}
