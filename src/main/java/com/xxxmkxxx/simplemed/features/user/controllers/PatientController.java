package com.xxxmkxxx.simplemed.features.user.controllers;

import com.xxxmkxxx.simplemed.common.DTO;
import com.xxxmkxxx.simplemed.features.registry.dto.AppointmentsDTO;
import com.xxxmkxxx.simplemed.features.registry.dto.MedicalCardDTO;
import com.xxxmkxxx.simplemed.features.user.dto.PrivatePatientInfoDTO;
import com.xxxmkxxx.simplemed.features.user.dto.PublicUserInfoDTO;
import com.xxxmkxxx.simplemed.features.user.models.PatientModel;
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
    public ResponseEntity<DTO> getPatientInfo(@RequestParam(name = "login") String patientLogin, @RequestParam(name = "private") Boolean isPrivateInfo) {
        PatientModel patient = patientService.getPatient(patientLogin);
        DTO dao;

        if (isPrivateInfo) {
            dao = new PrivatePatientInfoDTO(patient);
        } else {
            dao = new PublicUserInfoDTO(patient);
        }

        return new ResponseEntity<>(dao, HttpStatus.OK);
    }

    @GetMapping("/card")
    public ResponseEntity<MedicalCardDTO> getPatientCard(@RequestParam(name = "login") String patientLogin) {
        PatientModel patient = patientService.getPatient(patientLogin);

        return new ResponseEntity<>(new MedicalCardDTO(patient.getCard()), HttpStatus.OK);
    }

    @GetMapping("/appointments")
    public ResponseEntity<AppointmentsDTO> getAppointmentRecords(@RequestParam(name = "login") String patientLogin) {
        PatientModel patient = patientService.getPatient(patientLogin);

        return new ResponseEntity<>(new AppointmentsDTO(patient.getAdmissionRecords()), HttpStatus.OK);
    }
}
