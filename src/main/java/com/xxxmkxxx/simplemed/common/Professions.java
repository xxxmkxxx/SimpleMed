package com.xxxmkxxx.simplemed.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Professions {
    SURGEON("Хирург"),
    UROLOGIST("Уролог"),
    THERAPIST("Терапевт"),
    PSYCHIATRIST("Психиатор"),
    ONCOLOGIST("Онколог");

    @Getter
    private String name;
}
