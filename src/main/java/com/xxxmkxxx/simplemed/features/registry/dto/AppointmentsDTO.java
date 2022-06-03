package com.xxxmkxxx.simplemed.features.registry.dto;

import com.xxxmkxxx.simplemed.common.AppointmentStatusType;
import com.xxxmkxxx.simplemed.common.DTO;
import com.xxxmkxxx.simplemed.common.ModelConverterManager;
import com.xxxmkxxx.simplemed.features.user.dto.PublicUserInfoDTO;
import com.xxxmkxxx.simplemed.features.registry.models.AppointmentModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class AppointmentsDTO implements DTO {
    private List<AppointmentRecordDAO> records;

    @Getter @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private class AppointmentRecordDAO {
        private AppointmentStatusType appointmentStatus;
        private LocalDateTime dateTime;
        private PublicUserInfoDTO medic;
        private PublicUserInfoDTO patient;

        public AppointmentRecordDAO(AppointmentModel model) {
            this.appointmentStatus = model.getAppointmentStatus();
            this.dateTime = LocalDateTime.of(model.getDate(), model.getTime());
            this.medic = new PublicUserInfoDTO(model.getMedic());
            this.patient = new PublicUserInfoDTO(model.getPatient());
        }
    }

    public AppointmentsDTO(List<AppointmentModel> models) {
        ModelConverterManager<AppointmentRecordDAO, AppointmentModel> modelConverterManager = new ModelConverterManager<>();

        this.records =
                modelConverterManager.
                        convertModelList(
                                models,
                                m -> new AppointmentRecordDAO((AppointmentModel) m)
                        );
    }
}
