package com.xxxmkxxx.simplemed.controllers;

import com.xxxmkxxx.simplemed.common.Professions;
import com.xxxmkxxx.simplemed.models.MedicalStaffModel;
import com.xxxmkxxx.simplemed.repositories.MedicalStaffRepository;
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
    private MedicalStaffRepository medicalStaffRepository;

    @GetMapping("/{id}")
    public MedicalStaffModel getStaff(@PathVariable int id) {
        return medicalStaffRepository.getMedicalStaffModelByUserId(id);
    }

    @GetMapping("/professions")
    public ResponseEntity<String[]> getProfessions() {
        return new ResponseEntity<>(Professions.getProfessionsNames(), HttpStatus.OK);
    }
}
