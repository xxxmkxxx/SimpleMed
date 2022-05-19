package com.xxxmkxxx.simplemed.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "medical_card_record")
public class MedicalCardRecordModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String recordId;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private MedicalCardModel medicalCard;

    @Column(name = "disease_name")
    private String diseaseName;

    @Column(name = "description")
    private String description;

    @Column(name = "medical_comment")
    private String medicalComment;

    @Column(name = "conclusion")
    private String conclusion;
}
