package com.xxxmkxxx.simplemed.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PatientModel extends UserModel {
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "patient")
    private MedicalCardModel card;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private List<AppointmentModel> admissionRecords;
}
