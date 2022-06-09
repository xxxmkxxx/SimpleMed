package com.xxxmkxxx.simplemed.features.registry.repositories;

import com.xxxmkxxx.simplemed.features.registry.models.AppointmentEntryModel;
import com.xxxmkxxx.simplemed.features.user.models.MedicalStaffModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntryModel, Integer> {
    boolean existsAppointmentModelByDateAndTimeAndMedic(LocalDate date, LocalTime time, MedicalStaffModel medic);

    List<AppointmentEntryModel> getAllByDateAndMedic(LocalDate date, MedicalStaffModel medic);

    List<AppointmentEntryModel> getAllByDateBetweenAndMedic(LocalDate dateStart, LocalDate dateStop, MedicalStaffModel medic);
}

