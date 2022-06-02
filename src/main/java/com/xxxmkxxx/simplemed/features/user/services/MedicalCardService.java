package com.xxxmkxxx.simplemed.features.user.controllers;

import com.xxxmkxxx.simplemed.models.MedicalCardModel;
import com.xxxmkxxx.simplemed.models.PatientModel;
import org.springframework.stereotype.Service;

@Service
public class MedicalCardService {
    public MedicalCardModel getMedicalCard(PatientModel patient) {
        return patient.getCard();
    }
}
