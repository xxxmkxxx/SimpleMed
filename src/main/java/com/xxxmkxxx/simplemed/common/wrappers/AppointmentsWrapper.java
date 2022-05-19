package com.xxxmkxxx.simplemed.common.wrappers;

import com.xxxmkxxx.simplemed.models.AppointmentModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class AppointmentsWrapper implements Wrapper {
    private List<AppointmentRecordWrapper> records;

    @Getter @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private class AppointmentRecordWrapper {
        private Date date;
        private PublicUserInfoWrapper medic;
        private PublicUserInfoWrapper patient;

        public AppointmentRecordWrapper(AppointmentModel model) {
            this.date = model.getDate();
            this.medic = new PublicUserInfoWrapper(model.getMedic());
            this.patient = new PublicUserInfoWrapper(model.getPatient());
        }
    }

    public AppointmentsWrapper(List<AppointmentModel> models) {
        WrapperManager<AppointmentRecordWrapper, AppointmentModel> wrapperManager = new WrapperManager<>();

        this.records =
                wrapperManager.
                        convertModelList(
                                models,
                                m -> new AppointmentRecordWrapper((AppointmentModel) m)
                        );
    }
}
