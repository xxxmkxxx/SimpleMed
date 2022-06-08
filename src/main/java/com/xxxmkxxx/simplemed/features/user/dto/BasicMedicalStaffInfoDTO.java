package com.xxxmkxxx.simplemed.features.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class BasicMedicInfoDTO {
    private String profession;
    private LocalTime startWorkTime;
    private LocalTime endWorkTime;
    private String description;
    private int experience;
}
