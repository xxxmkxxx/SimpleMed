package com.xxxmkxxx.simplemed.features.user.controllers;

import com.xxxmkxxx.simplemed.dao.*;
import com.xxxmkxxx.simplemed.features.user.services.UserService;
import com.xxxmkxxx.simplemed.models.PatientModel;
import com.xxxmkxxx.simplemed.features.user.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:8081"})
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/get")
    public ResponseEntity<DAO> getPatientInfo(@RequestParam(name = "login") String patientLogin, @RequestParam(name = "private") Boolean isPrivateInfo) {
        PatientModel patient = patientService.getPatient(patientLogin);
        DAO dao;

        if (isPrivateInfo) {
            dao = new PrivatePatientInfoDAO(patient);
        } else {
            dao = new PublicUserInfoDAO(patient);
        }

        return new ResponseEntity<>(dao, HttpStatus.OK);
    }

    @GetMapping("/card")
    public ResponseEntity<MedicalCardDAO> getPatientCard(@RequestParam(name = "login") String patientLogin) {
        PatientModel patient = patientService.getPatient(patientLogin);

        return new ResponseEntity<>(new MedicalCardDAO(patient.getCard()), HttpStatus.OK);
    }

    @GetMapping("/appointments")
    public ResponseEntity<AppointmentsDAO> getAppointmentRecords(@RequestParam(name = "login") String patientLogin) {
        PatientModel patient = patientService.getPatient(patientLogin);

        return new ResponseEntity<>(new AppointmentsDAO(patient.getAdmissionRecords()), HttpStatus.OK);
    }
}
