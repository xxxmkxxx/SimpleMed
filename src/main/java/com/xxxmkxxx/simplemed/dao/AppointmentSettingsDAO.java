package com.xxxmkxxx.simplemed.dao;

import com.xxxmkxxx.simplemed.configs.SMConfig;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class AppointmentSettingsDAO {
    private final int mInterval = SMConfig.APPOINTMENT_M_INTERVAL;
}
