package com.xxxmkxxx.simplemed.features.registry.models;

import com.xxxmkxxx.simplemed.features.user.models.PatientModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medical_cards")
@Getter @Setter
@NoArgsConstructor
public class MedicalCardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private PatientModel patient;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalCard")
    private List<MedicalCardRecordModel> records;
}
