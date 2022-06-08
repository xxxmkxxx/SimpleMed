package com.xxxmkxxx.simplemed.features.registry.dto;

import com.xxxmkxxx.simplemed.common.AppointmentStatusType;
import com.xxxmkxxx.simplemed.features.user.dto.BasicUserInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
public class AppointmentRecordDTO {
    private AppointmentStatusType appointmentStatus;
    private LocalDateTime dateTime;
    private BasicUserInfoDTO medic;
    private BasicUserInfoDTO patient;
}
