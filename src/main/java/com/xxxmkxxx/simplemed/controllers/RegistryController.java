package com.xxxmkxxx.simplemed.controllers;

import com.xxxmkxxx.simplemed.common.Message;
import com.xxxmkxxx.simplemed.common.Professions;
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
import java.util.List;

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

    @GetMapping("/appointments")
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
            @RequestParam(name = "medic", defaultValue = "0") int medicId,
            @RequestParam(name = "profession", defaultValue = "none") String professionName,
            @RequestParam(name = "date") @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm") LocalDateTime dateTime
    ) {
        Message message = new Message("none", Message.MessageType.ERROR);
        PatientModel patient = patientService.getPatient(patientId);

        if (!professionName.equals("none")) {
            List<MedicalStaffModel> medics = medicalStaffService.getMedics(Professions.getProfessionByName(professionName));
            message = appointmentsService.createAppointment(dateTime, medics, patient);
        } else if (medicId != 0){
            MedicalStaffModel medic = medicalStaffService.getMedic(medicId);
            message = appointmentsService.createAppointment(dateTime, medic, patient);
        }

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
