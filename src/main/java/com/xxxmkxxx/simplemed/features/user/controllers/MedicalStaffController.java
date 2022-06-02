package com.xxxmkxxx.simplemed.features.user.controllers;

import com.xxxmkxxx.simplemed.common.Professions;
import com.xxxmkxxx.simplemed.models.MedicalStaffModel;
import com.xxxmkxxx.simplemed.dao.BasicMedicInfoDAO;
import com.xxxmkxxx.simplemed.features.user.services.MedicalStaffService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
@AllArgsConstructor
public class MedicalStaffController {
    private final MedicalStaffService medicalStaffService;

    @GetMapping("/{id}")
    public ResponseEntity<BasicMedicInfoDAO> getMedicInfo(@PathVariable int id) {
        MedicalStaffModel medic = medicalStaffService.getMedic(id);

        return new ResponseEntity<>(new BasicMedicInfoDAO(medic), HttpStatus.OK);
    }

    @GetMapping("/professions")
    public ResponseEntity<String[]> getProfessions() {
        return new ResponseEntity<>(Professions.getProfessionsNames(), HttpStatus.OK);
    }
}