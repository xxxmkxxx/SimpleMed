package com.xxxmkxxx.simplemed.controllers;

import com.xxxmkxxx.simplemed.common.Message;
import com.xxxmkxxx.simplemed.wrappers.AppointmentsWrapper;
import com.xxxmkxxx.simplemed.wrappers.settings.AppointmentSettingsWrapper;
import com.xxxmkxxx.simplemed.models.AppointmentModel;
import com.xxxmkxxx.simplemed.models.MedicalStaffModel;
import com.xxxmkxxx.simplemed.models.PatientModel;
import com.xxxmkxxx.simplemed.services.AppointmentsService;
import com.xxxmkxxx.simplemed.services.MedicalStaffService;
import com.xxxmkxxx.simplemed.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins = {"http://localhost:8081"})
@RequestMapping("/registry")
@RequiredArgsConstructor
public class RegistryController {
    private final AppointmentsService appointmentsService;
    private final PatientService patientService;
    private final MedicalStaffService medicalStaffService;
    @GetMapping("/")
    public ResponseEntity<AppointmentSettingsWrapper> getInterval() {
        return new ResponseEntity<>(new AppointmentSettingsWrapper(), HttpStatus.OK);
    }

    @GetMapping("/appointment/all")
    public ResponseEntity<AppointmentsWrapper> getAppointmentsByDate(
            @RequestParam(name = "date") @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm") LocalDateTime dateTime,
            @RequestParam(name = "medic") int medicId
    ) {
        MedicalStaffModel medic = medicalStaffService.getMedic(medicId);
        AppointmentsWrapper wrapper = new AppointmentsWrapper(appointmentsService.getAppointmentsByDate(dateTime.toLocalDate(), medic));

        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }

    @PostMapping("/appointment/create")
    public ResponseEntity<Message> createAppointment(
            @RequestParam(name = "patient") int patientId,
            @RequestParam(name = "medic") int medicId,
            @RequestParam(name = "date") @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm") LocalDateTime dateTime
    ) {
        MedicalStaffModel medic = medicalStaffService.getMedic(medicId);
        PatientModel patient = patientService.getPatient(patientId);

        AppointmentModel appointment = AppointmentModel.builder()
                .date(dateTime.toLocalDate()).time(dateTime.toLocalTime())
                .medic(medic).patient(patient)
                .build();

        Message message = appointmentsService.safeAppointment(appointment);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
