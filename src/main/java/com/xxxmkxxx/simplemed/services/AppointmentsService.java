package com.xxxmkxxx.simplemed.services;

import com.xxxmkxxx.simplemed.common.Message;
import com.xxxmkxxx.simplemed.common.Professions;
import com.xxxmkxxx.simplemed.configs.SMConfig;
import com.xxxmkxxx.simplemed.models.AppointmentModel;
import com.xxxmkxxx.simplemed.models.MedicalStaffModel;
import com.xxxmkxxx.simplemed.models.PatientModel;
import com.xxxmkxxx.simplemed.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public record AppointmentsService(
        AppointmentRepository appointmentRepository
) {
    public Message safeAppointment(AppointmentModel appointment) {
        if (!isTimeFree(appointment.getDate(), appointment.getTime(), appointment.getMedic())) {
            return new Message("Невозможно записать несколько человек на одно и тоже время!", Message.MessageType.ERROR);
        }

        appointmentRepository.save(appointment);

        return new Message("Запись успешно создана!", Message.MessageType.MESSAGE);
    }

    public AppointmentModel createAppointment(PatientModel patient, MedicalStaffModel medic, Date date, Date time) {


        return AppointmentModel.builder().
                patient(patient).
                medic(medic).
                date(date).
                time(time).
                build();
    }

    private boolean isTimeFree(Date date, Date time, MedicalStaffModel medic) {
        AppointmentModel appointment = appointmentRepository.getAppointmentModelByDateAndTimeAndMedic(date, time, medic);

        return appointment == null;
    }

    private boolean isCorrectInterval(int interval) {
        return interval == SMConfig.APPOINTMENT_M_INTERVAL;
    }

    public List<AppointmentModel> getAppointmentsByDate(Date date, Professions profession) {
        return appointmentRepository.getAllByDateAndMedic_Profession(date, profession);
    }

}
