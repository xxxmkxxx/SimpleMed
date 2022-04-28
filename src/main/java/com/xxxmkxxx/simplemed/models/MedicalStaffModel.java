package com.xxxmkxxx.simplemed.models;

import com.xxxmkxxx.simplemed.common.Professions;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "medical_staff")
public class MedicalStaffModel extends UserModel {
    @Enumerated(EnumType.STRING)
    private Professions profession;

    @Column(name = "description")
    private String description;

    @Column(name = "experience")
    private int experience;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medic")
    private List<AdmissionRecordModel> admissionRecords;
}
