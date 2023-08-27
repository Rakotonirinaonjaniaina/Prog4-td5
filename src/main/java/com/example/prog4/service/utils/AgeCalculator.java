package com.example.prog4.service.utils;

import java.time.LocalDate;

public class AgeCalculator {
    public static int fromBirth(LocalDate birthDate) {
        if (birthDate == null){
            return 0;
        }
        LocalDate current = LocalDate.now();
        LocalDate reference = LocalDate.of(current.getYear(), birthDate.getMonth(), birthDate.getDayOfMonth());
        int birthYear = birthDate.getYear();
        int age = current.getYear() - birthYear;
        System.out.println(reference);
        if(reference.isAfter(birthDate)){
            age-= 1;
        }
        return age;
    }
}
