package com.xxxmkxxx.simplemed.features.user.models;

import com.xxxmkxxx.simplemed.common.Professions;
import com.xxxmkxxx.simplemed.features.registry.models.AppointmentModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
public class MedicalStaffModel extends UserModel {
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medic")
    private List<AppointmentModel> admissionRecords;
}
