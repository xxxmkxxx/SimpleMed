package com.xxxmkxxx.simplemed.responses;

import com.xxxmkxxx.simplemed.common.AppointmentStatusType;
import com.xxxmkxxx.simplemed.common.ModelConverterManager;
import com.xxxmkxxx.simplemed.models.AppointmentModel;
import com.xxxmkxxx.simplemed.wrappers.PublicUserInfoWrapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class AppointmentsResponse implements Response {
    private List<AppointmentRecordResponse> records;

    @Getter @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private class AppointmentRecordResponse {
        private AppointmentStatusType appointmentStatus;
        private LocalDateTime dateTime;
        private PublicUserInfoWrapper medic;
        private PublicUserInfoWrapper patient;

        public AppointmentRecordResponse(AppointmentModel model) {
            this.appointmentStatus = model.getAppointmentStatus();
            this.dateTime = LocalDateTime.of(model.getDate(), model.getTime());
            this.medic = new PublicUserInfoWrapper(model.getMedic());
            this.patient = new PublicUserInfoWrapper(model.getPatient());
        }
    }

    public AppointmentsResponse(List<AppointmentModel> models) {
        ModelConverterManager<AppointmentRecordResponse, AppointmentModel> modelConverterManager = new ModelConverterManager<>();

        this.records =
                modelConverterManager.
                        convertModelList(
                                models,
                                m -> new AppointmentRecordResponse((AppointmentModel) m)
                        );
    }
}
