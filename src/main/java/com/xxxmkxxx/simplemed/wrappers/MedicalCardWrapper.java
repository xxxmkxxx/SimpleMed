package com.xxxmkxxx.simplemed.wrappers;

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
public class MedicalCardWrapper implements Wrapper {
    private List<MedicalCardRecordWrapper> cardRecords;

    public MedicalCardWrapper(MedicalCardModel model) {
        WrapperManager<MedicalCardRecordWrapper, MedicalCardRecordModel> wrapperManager = new WrapperManager<>();

        this.cardRecords =
                wrapperManager.
                        convertModelList(
                                model.getRecords(),
                                m -> new MedicalCardRecordWrapper((MedicalCardRecordModel) m)
                        );
    }

    @Getter @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class MedicalCardRecordWrapper implements Wrapper {
        private String diseaseName;
        private String description;
        private String medicalComment;
        private String conclusion;

        public MedicalCardRecordWrapper(MedicalCardRecordModel model) {
            this.diseaseName = model.getDiseaseName();
            this.description = model.getDescription();
            this.medicalComment = model.getMedicalComment();
            this.conclusion = model.getConclusion();
        }
    }
}
