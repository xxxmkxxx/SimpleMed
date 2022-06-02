package com.xxxmkxxx.simplemed.dao;

import com.xxxmkxxx.simplemed.common.AppointmentStatusType;
import com.xxxmkxxx.simplemed.common.ModelConverterManager;
import com.xxxmkxxx.simplemed.models.AppointmentModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class AppointmentsDAO implements DAO {
    private List<AppointmentRecordDAO> records;

    @Getter @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private class AppointmentRecordDAO {
        private AppointmentStatusType appointmentStatus;
        private LocalDateTime dateTime;
        private PublicUserInfoDAO medic;
        private PublicUserInfoDAO patient;

        public AppointmentRecordDAO(AppointmentModel model) {
            this.appointmentStatus = model.getAppointmentStatus();
            this.dateTime = LocalDateTime.of(model.getDate(), model.getTime());
            this.medic = new PublicUserInfoDAO(model.getMedic());
            this.patient = new PublicUserInfoDAO(model.getPatient());
        }
    }

    public AppointmentsDAO(List<AppointmentModel> models) {
        ModelConverterManager<AppointmentRecordDAO, AppointmentModel> modelConverterManager = new ModelConverterManager<>();

        this.records =
                modelConverterManager.
                        convertModelList(
                                models,
                                m -> new AppointmentRecordDAO((AppointmentModel) m)
                        );
    }
}
