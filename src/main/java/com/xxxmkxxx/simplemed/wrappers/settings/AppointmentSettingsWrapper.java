package com.xxxmkxxx.simplemed.common.wrappers.settings;

import com.xxxmkxxx.simplemed.configs.SMConfig;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class AppointmentSettingsWrapper {
    private final int mInterval = SMConfig.APPOINTMENT_M_INTERVAL;
}
