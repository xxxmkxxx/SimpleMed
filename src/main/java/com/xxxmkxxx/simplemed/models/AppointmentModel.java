package com.xxxmkxxx.simplemed.models;

import com.xxxmkxxx.simplemed.common.AppointmentStatusType;
import com.xxxmkxxx.simplemed.common.PatientStatusType;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "appointments")
public class AppointmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recordId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Enumerated(EnumType.STRING)
    @Column(name = "appointment_status")
    @ColumnDefault(value = "'NOT_STARTED'")
    @org.hibernate.annotations.Generated(GenerationTime.INSERT)
    private AppointmentStatusType appointmentStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "patient_status")
    @ColumnDefault(value = "NONE")
    @org.hibernate.annotations.Generated(GenerationTime.INSERT)
    private PatientStatusType patientStatus = PatientStatusType.NONE;

    @Column(name = "medic_comment")
    private String medicComment;

    @ManyToOne
    @JoinColumn(name = "medic_id")
    private MedicalStaffModel medic;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientModel patient;
}
