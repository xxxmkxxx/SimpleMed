package com.xxxmkxxx.simplemed.features.registry.dto;

import com.xxxmkxxx.simplemed.common.DTO;
import com.xxxmkxxx.simplemed.common.ModelConverterManager;
import com.xxxmkxxx.simplemed.features.registry.models.MedicalCardModel;
import com.xxxmkxxx.simplemed.features.registry.models.MedicalCardRecordModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalCardDTO implements DTO {
    private List<MedicalCardRecordDTO> cardRecords;

    public MedicalCardDTO(MedicalCardModel model) {
        ModelConverterManager<MedicalCardRecordDTO, MedicalCardRecordModel> modelConverterManager = new ModelConverterManager<>();

        this.cardRecords =
                modelConverterManager.
                        convertModelList(
                                model.getRecords(),
                                m -> new MedicalCardRecordDTO((MedicalCardRecordModel) m)
                        );
    }

    @Getter @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class MedicalCardRecordDTO implements DTO {
        private String diseaseName;
        private String description;
        private String medicalComment;
        private String conclusion;

        public MedicalCardRecordDTO(MedicalCardRecordModel model) {
            this.diseaseName = model.getDiseaseName();
            this.description = model.getDescription();
            this.medicalComment = model.getMedicalComment();
            this.conclusion = model.getConclusion();
        }
    }
}
