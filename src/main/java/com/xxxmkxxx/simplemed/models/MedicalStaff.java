package com.xxxmkxxx.simplemed.models;

import com.xxxmkxxx.simplemed.common.Professions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalStaff extends User {
    private Professions profession;
    private List<String> appointmentHours;
    private String description;
    private int experience;
    private List<Review> reviews;
}
