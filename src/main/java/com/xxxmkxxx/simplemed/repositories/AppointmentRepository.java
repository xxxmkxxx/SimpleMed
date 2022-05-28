package com.xxxmkxxx.simplemed.repositories;

import com.xxxmkxxx.simplemed.models.AppointmentModel;
import com.xxxmkxxx.simplemed.models.MedicalStaffModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentModel, Integer> {
    boolean existsAppointmentModelByDateAndTimeAndMedic(LocalDate date, LocalTime time, MedicalStaffModel medic);

    List<AppointmentModel> getAllByDateAndMedic(LocalDate date, MedicalStaffModel medic);

    List<AppointmentModel> getAllByDateBetweenAndMedic(LocalDate dateStart, LocalDate dateStop, MedicalStaffModel medic);
}

