package com.xxxmkxxx.simplemed.features.user.models;

import com.xxxmkxxx.simplemed.features.registry.models.AppointmentEntryModel;
import com.xxxmkxxx.simplemed.features.registry.models.MedicalCardModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class PatientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    @Column(name = "date_of_birth")
    private LocalDateTime dateOfBirth;

    @Column(name = "weight")
    private double weight;

    @Column(name = "height")
    private double height;

    @OneToOne
    private UserModel user;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "patient")
    private MedicalCardModel card;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    private List<AppointmentEntryModel> admissionRecords;
}
