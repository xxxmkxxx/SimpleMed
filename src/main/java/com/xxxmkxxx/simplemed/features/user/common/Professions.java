package com.xxxmkxxx.simplemed.features.user.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public enum Professions {
    SURGEON("Хирург"),
    UROLOGIST("Уролог"),
    THERAPIST("Терапевт"),
    PSYCHIATRIST("Психиатор"),
    ONCOLOGIST("Онколог");

    @Getter
    private final String name;

    public static String[] getProfessionsNames() {
        List<String> names = new ArrayList<>();

        for (Professions profession : Professions.values()) {
            names.add(profession.getName());
        }

        return names.toArray(new String[Professions.values().length]);
    }

    public static Professions getProfessionByName(String name) {
        for (Professions profession : Professions.values()) {
            if (profession.getName().equals(name))
                return profession;
        }

        return null;
    }
}
