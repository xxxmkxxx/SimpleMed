package com.xxxmkxxx.simplemed.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "appointment_records")
public class AppointmentRecordModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recordId;

    @Column(name = "date_receipt")
    private Date timeOfReceipt;

    @ManyToOne
    @JoinColumn(name = "medic_id")
    private MedicalStaffModel medic;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientModel patient;
}
