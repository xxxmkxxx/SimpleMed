package com.xxxmkxxx.simplemed.features.registry.controllers;

import com.xxxmkxxx.simplemed.common.Message;
import com.xxxmkxxx.simplemed.common.Professions;
import com.xxxmkxxx.simplemed.dao.AppointmentsDAO;
import com.xxxmkxxx.simplemed.dao.AppointmentSettingsDAO;
import com.xxxmkxxx.simplemed.models.MedicalStaffModel;
import com.xxxmkxxx.simplemed.models.PatientModel;
import com.xxxmkxxx.simplemed.features.registry.services.AppointmentsService;
import com.xxxmkxxx.simplemed.features.user.services.MedicalStaffService;
import com.xxxmkxxx.simplemed.features.user.services.PatientService;
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
    public ResponseEntity<AppointmentSettingsDAO> getInterval() {
        return new ResponseEntity<>(new AppointmentSettingsDAO(), HttpStatus.OK);
    }

    @GetMapping("/appointments")
    public ResponseEntity<AppointmentsDAO> getAppointments(
            @RequestParam(name = "weekly") boolean isWeekly,
            @RequestParam(name = "date") @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm") LocalDateTime dateTime,
            @RequestParam(name = "medic") String medicLogin
    ) {
        AppointmentsDAO response;
        MedicalStaffModel medic = medicalStaffService.getMedic(medicLogin);

        if (isWeekly) {
            response = new AppointmentsDAO(appointmentsService.getAppointmentsByWeek(dateTime.toLocalDate(), medic));
        } else {
            response = new AppointmentsDAO(appointmentsService.getAppointmentsByDate(dateTime.toLocalDate(), medic));
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/appointment")
    public ResponseEntity<Message> createAppointment(
            @RequestParam(name = "patient") String patientLogin,
            @RequestParam(name = "medic") String medicLogin,
            @RequestParam(name = "profession", defaultValue = "none") String professionName,
            @RequestParam(name = "date") @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm") LocalDateTime dateTime
    ) {
        Message message = new Message("none", Message.MessageType.ERROR);
        PatientModel patient = patientService.getPatient(patientLogin);

        if (!professionName.equals("none")) {
            List<MedicalStaffModel> medics = medicalStaffService.getMedics(Professions.getProfessionByName(professionName));
            message = appointmentsService.createAppointment(dateTime, medics, patient);
        } else if (!medicLogin.equals("none")){
            MedicalStaffModel medic = medicalStaffService.getMedic(medicLogin);
            message = appointmentsService.createAppointment(dateTime, medic, patient);
        }

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
