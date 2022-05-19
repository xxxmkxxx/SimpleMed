package com.xxxmkxxx.simplemed.repositories;

import com.xxxmkxxx.simplemed.common.Professions;
import com.xxxmkxxx.simplemed.models.AppointmentModel;
import com.xxxmkxxx.simplemed.models.MedicalStaffModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentModel, Integer> {
    AppointmentModel getAppointmentModelByDateAndTimeAndMedic(Date date, Date time, MedicalStaffModel medic);

    List<AppointmentModel> getAllByDateAndMedic_Profession(Date date, Professions profession);
}

