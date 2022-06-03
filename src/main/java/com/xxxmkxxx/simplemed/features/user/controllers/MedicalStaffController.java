package com.xxxmkxxx.simplemed.features.user.controllers;

import com.xxxmkxxx.simplemed.common.Professions;
import com.xxxmkxxx.simplemed.features.user.models.MedicalStaffModel;
import com.xxxmkxxx.simplemed.features.user.dto.BasicMedicInfoDTO;
import com.xxxmkxxx.simplemed.features.user.services.MedicalStaffService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
@AllArgsConstructor
public class MedicalStaffController {
    private final MedicalStaffService medicalStaffService;

    @GetMapping("/get")
    public ResponseEntity<BasicMedicInfoDTO> getMedicInfo(@RequestParam(name = "medic") String medicLogin) {
        MedicalStaffModel medic = medicalStaffService.getMedic(medicLogin);

        return new ResponseEntity<>(new BasicMedicInfoDTO(medic), HttpStatus.OK);
    }

    @GetMapping("/professions")
    public ResponseEntity<String[]> getProfessions() {
        return new ResponseEntity<>(Professions.getProfessionsNames(), HttpStatus.OK);
    }
}
