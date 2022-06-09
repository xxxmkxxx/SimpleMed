package com.xxxmkxxx.simplemed.features.user.models;

import com.xxxmkxxx.simplemed.features.user.common.Professions;
import com.xxxmkxxx.simplemed.features.registry.models.AppointmentEntryModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "staff")
public class MedicalStaffModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicalStaffId;

    @Enumerated(EnumType.STRING)
    private Professions profession;

    @Column(name = "start_work_time")
    LocalTime startWorkTime;

    @Column(name = "end_work_time")
    LocalTime endWorkTime;

    @Column(name = "description")
    private String description;

    @Column(name = "experience")
    private int experience;

    @OneToOne
    private UserModel user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medic")
    private List<AppointmentEntryModel> admissionRecords;
}
