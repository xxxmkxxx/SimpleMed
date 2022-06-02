package com.xxxmkxxx.simplemed.dao;

import com.xxxmkxxx.simplemed.common.ModelConverterManager;
import com.xxxmkxxx.simplemed.models.MedicalCardModel;
import com.xxxmkxxx.simplemed.models.MedicalCardRecordModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalCardDAO implements DAO {
    private List<MedicalCardRecordDAO> cardRecords;

    public MedicalCardDAO(MedicalCardModel model) {
        ModelConverterManager<MedicalCardRecordDAO, MedicalCardRecordModel> modelConverterManager = new ModelConverterManager<>();

        this.cardRecords =
                modelConverterManager.
                        convertModelList(
                                model.getRecords(),
                                m -> new MedicalCardRecordDAO((MedicalCardRecordModel) m)
                        );
    }

    @Getter @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class MedicalCardRecordDAO implements DAO {
        private String diseaseName;
        private String description;
        private String medicalComment;
        private String conclusion;

        public MedicalCardRecordDAO(MedicalCardRecordModel model) {
            this.diseaseName = model.getDiseaseName();
            this.description = model.getDescription();
            this.medicalComment = model.getMedicalComment();
            this.conclusion = model.getConclusion();
        }
    }
}
