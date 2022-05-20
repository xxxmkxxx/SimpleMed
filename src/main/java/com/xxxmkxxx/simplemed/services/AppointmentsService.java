package com.xxxmkxxx.simplemed.services;

import com.xxxmkxxx.simplemed.common.Message;
import com.xxxmkxxx.simplemed.common.Professions;
import com.xxxmkxxx.simplemed.configs.SMConfig;
import com.xxxmkxxx.simplemed.models.AppointmentModel;
import com.xxxmkxxx.simplemed.models.MedicalStaffModel;
import com.xxxmkxxx.simplemed.models.PatientModel;
import com.xxxmkxxx.simplemed.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public record AppointmentsService(
        AppointmentRepository appointmentRepository
) {
    public Message safeAppointment(AppointmentModel appointment) {
        if (!isWorkingTime(appointment.getTime(), appointment.getMedic())) {
            return new Message("Невозможно сделать запись вне рабочего времени врача!", Message.MessageType.ERROR);
        } else if (!isCorrectTimeInterval(appointment.getTime())) {
            return new Message("Невозможно сделать запись из-за некорректного интервала времени!", Message.MessageType.ERROR);
        } else if (!isAppointmentFree(appointment)) {
            return new Message("Невозможно записать несколько человек на одно и тоже время!", Message.MessageType.ERROR);
        }

        appointmentRepository.save(appointment);

        return new Message("Запись успешно создана!", Message.MessageType.MESSAGE);
    }

    private boolean isAppointmentFree(AppointmentModel appointment) {
        return !appointmentRepository.existsAppointmentModelByDateAndTimeAndMedic(
                appointment.getDate(),
                appointment.getTime(),
                appointment.getMedic()
        );
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

}
