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
public class MedicalStaffModel extends UserModel {
    private Professions profession;
    private String description;
    private int experience;
    private List<ReviewModel> reviews;
}
