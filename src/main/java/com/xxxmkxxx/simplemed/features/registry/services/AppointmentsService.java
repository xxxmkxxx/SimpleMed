package com.xxxmkxxx.simplemed.features.registry.services;

import com.xxxmkxxx.simplemed.common.Message;
import com.xxxmkxxx.simplemed.configs.SMConfig;
import com.xxxmkxxx.simplemed.features.registry.repositories.AppointmentRepository;
import com.xxxmkxxx.simplemed.models.AppointmentModel;
import com.xxxmkxxx.simplemed.models.MedicalStaffModel;
import com.xxxmkxxx.simplemed.models.PatientModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public record AppointmentsService(
        AppointmentRepository appointmentRepository
) {
    public Message createAppointment(LocalDateTime dateTime, MedicalStaffModel medic, PatientModel patient) {
        if (!isWorkingTime(dateTime.toLocalTime(), medic)) {
            return new Message("Невозможно сделать запись вне рабочего времени врача!", Message.MessageType.ERROR);
        } else if (!isCorrectTimeInterval(dateTime.toLocalTime())) {
            return new Message("Невозможно сделать запись из-за некорректного интервала времени!", Message.MessageType.ERROR);
        } else if (!isAppointmentFree(dateTime.toLocalDate(), dateTime.toLocalTime(), medic)) {
            return new Message("Невозможно записать несколько человек на одно и тоже время к одному врачу!", Message.MessageType.ERROR);
        }

        AppointmentModel appointment = AppointmentModel.builder()
                        .patient(patient).medic(medic)
                        .date(dateTime.toLocalDate()).time(dateTime.toLocalTime())
                        .build();

        appointmentRepository.save(appointment);

        return new Message("Запись успешно создана!", Message.MessageType.SUCCESS);
    }

    public Message createAppointment(LocalDateTime dateTime, List<MedicalStaffModel> medics, PatientModel patient) {
        Message message = new Message("none", Message.MessageType.ERROR);

        for (MedicalStaffModel medic : medics) {
            message = createAppointment(dateTime, medic, patient);

            if (message.getType() == Message.MessageType.SUCCESS)
                return message;
        }

        return message;
    }

    private boolean isAppointmentFree(LocalDate date, LocalTime time, MedicalStaffModel medic) {
        return !appointmentRepository.existsAppointmentModelByDateAndTimeAndMedic(date, time, medic);
    }

    private boolean isCorrectTimeInterval(LocalTime time) {
        return time.getMinute() % SMConfig.APPOINTMENT_M_INTERVAL == 0;
    }

    private boolean isWorkingTime(LocalTime time, MedicalStaffModel medic) {
        return time.isAfter(medic.getStartWorkTime()) && time.isBefore(medic.getEndWorkTime());
    }

    public List<AppointmentModel> getAppointmentsByDate(LocalDate date, MedicalStaffModel medic) {
        return appointmentRepository.getAllByDateAndMedic(date, medic);
    }

    public List<AppointmentModel> getAppointmentsByWeek(LocalDate date, MedicalStaffModel medic) {
        return appointmentRepository.getAllByDateBetweenAndMedic(date,date.plusDays(6), medic);
    }

}
