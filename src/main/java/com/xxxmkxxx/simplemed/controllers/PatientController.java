package com.xxxmkxxx.simplemed.controllers;

import com.xxxmkxxx.simplemed.common.wrappers.*;
import com.xxxmkxxx.simplemed.models.PatientModel;
import com.xxxmkxxx.simplemed.services.PatientService;
import lombok.*;
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
    public ResponseEntity<Wrapper> getPatientInfo(@PathVariable(name = "id") int patientId, @RequestParam(name = "private") Boolean isPrivateInfo) {
        PatientModel patient = patientService.getPatient(patientId);
        Wrapper wrapper;

        if (isPrivateInfo) {
            wrapper = new PrivatePatientInfoWrapper(patient);
        } else {
            wrapper = new PublicUserInfoWrapper(patient);
        }

        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }

    @GetMapping("/card")
    public ResponseEntity<MedicalCardWrapper> getPatientCard(@PathVariable(name = "id") int patientId) {
        PatientModel patient = patientService.getPatient(patientId);

        return new ResponseEntity<>(new MedicalCardWrapper(patient.getCard()), HttpStatus.OK);
    }

    @GetMapping("/appointments")
    public ResponseEntity<AppointmentsWrapper> getAppointmentRecords(@PathVariable(name = "id") int patientId) {
        PatientModel patient = patientService.getPatient(patientId);

        return new ResponseEntity<>(new AppointmentsWrapper(patient.getAdmissionRecords()), HttpStatus.OK);
    }
}
