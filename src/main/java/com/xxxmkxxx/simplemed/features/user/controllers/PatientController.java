package com.xxxmkxxx.simplemed.features.user.controllers;

import com.xxxmkxxx.simplemed.dao.*;
import com.xxxmkxxx.simplemed.models.PatientModel;
import com.xxxmkxxx.simplemed.features.user.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:8081"})
@RequestMapping("/patient/{id}")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/info")
    public ResponseEntity<DAO> getPatientInfo(@PathVariable(name = "id") int patientId, @RequestParam(name = "private") Boolean isPrivateInfo) {
        PatientModel patient = patientService.getPatient(patientId);
        DAO DAO;

        if (isPrivateInfo) {
            DAO = new PrivatePatientInfoDAO(patient);
        } else {
            DAO = new PublicUserInfoDAO(patient);
        }

        return new ResponseEntity<>(DAO, HttpStatus.OK);
    }

    @GetMapping("/card")
    public ResponseEntity<MedicalCardDAO> getPatientCard(@PathVariable(name = "id") int patientId) {
        PatientModel patient = patientService.getPatient(patientId);

        return new ResponseEntity<>(new MedicalCardDAO(patient.getCard()), HttpStatus.OK);
    }

    @GetMapping("/appointments")
    public ResponseEntity<AppointmentsDAO> getAppointmentRecords(@PathVariable(name = "id") int patientId) {
        PatientModel patient = patientService.getPatient(patientId);

        return new ResponseEntity<>(new AppointmentsDAO(patient.getAdmissionRecords()), HttpStatus.OK);
    }
}
