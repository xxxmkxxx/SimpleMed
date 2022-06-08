package com.xxxmkxxx.simplemed.features.user.controllers;

import com.xxxmkxxx.simplemed.features.mapper.ModelConverterManager;
import com.xxxmkxxx.simplemed.features.mapper.converters.AppointmentsConverter;
import com.xxxmkxxx.simplemed.features.mapper.converters.BasicMedicalStaffInfoConverter;
import com.xxxmkxxx.simplemed.features.mapper.converters.BasicUserInfoConverter;
import com.xxxmkxxx.simplemed.features.mapper.converters.MedicalCardConverter;
import com.xxxmkxxx.simplemed.features.registry.dto.AppointmentsDTO;
import com.xxxmkxxx.simplemed.features.registry.dto.MedicalCardDTO;
import com.xxxmkxxx.simplemed.features.user.dto.BasicMedicalStaffInfoDTO;
import com.xxxmkxxx.simplemed.features.user.dto.BasicUserInfoDTO;
import com.xxxmkxxx.simplemed.features.user.dto.PrivatePatientInfoDTO;
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
    public ResponseEntity<BasicUserInfoDTO> getPatientInfo(@RequestParam(name = "login") String patientLogin, @RequestParam(name = "private") Boolean isPrivateInfo) {
        PatientModel patient = patientService.getPatient(patientLogin);
        ModelConverterManager<BasicUserInfoDTO> converterManager = new ModelConverterManager<>(new BasicUserInfoConverter(patient));

        return new ResponseEntity<>(converterManager.createDTO(), HttpStatus.OK);
    }

    @GetMapping("/card")
    public ResponseEntity<MedicalCardDTO> getPatientCard(@RequestParam(name = "login") String patientLogin) {
        PatientModel patient = patientService.getPatient(patientLogin);
        ModelConverterManager<MedicalCardDTO> converterManager = new ModelConverterManager<>(new MedicalCardConverter(patient.getCard().getRecords()));

        return new ResponseEntity<>(converterManager.createDTO(), HttpStatus.OK);
    }

    @GetMapping("/appointments")
    public ResponseEntity<AppointmentsDTO> getAppointmentRecords(@RequestParam(name = "login") String patientLogin) {
        PatientModel patient = patientService.getPatient(patientLogin);
        ModelConverterManager<AppointmentsDTO> converterManager = new ModelConverterManager<>(new AppointmentsConverter(patient.getAdmissionRecords()));

        return new ResponseEntity<>(converterManager.createDTO(), HttpStatus.OK);
    }
}
