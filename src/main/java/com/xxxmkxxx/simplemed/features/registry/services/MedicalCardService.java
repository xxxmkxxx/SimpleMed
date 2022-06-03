package com.xxxmkxxx.simplemed.features.registry.services;

import com.xxxmkxxx.simplemed.features.registry.models.MedicalCardModel;
import com.xxxmkxxx.simplemed.features.user.models.PatientModel;
import org.springframework.stereotype.Service;

@Service
public class MedicalCardService {
    public MedicalCardModel getMedicalCard(PatientModel patient) {
        return patient.getCard();
    }
}
