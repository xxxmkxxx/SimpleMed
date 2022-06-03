package com.xxxmkxxx.simplemed.features.user.models;

import com.xxxmkxxx.simplemed.features.registry.models.AppointmentModel;
import com.xxxmkxxx.simplemed.features.registry.models.MedicalCardModel;
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
