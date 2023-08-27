package com.example.prog4.controller.validator;

import com.example.prog4.model.Phone;
import com.example.prog4.model.exception.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PhoneValidator {
    public void validate(Phone phone) {
        StringBuilder error = new StringBuilder();

        if (phone.getCountryCode() == null) {
            error.append("Phone's country code is mandatory. ");
        }

        if (phone.getValue() == null) {
            error.append("Phone's number is mandatory. ");
        }

        if (phone.getCountryCode() == null) {
            error.append("Phone's country code is mandatory. ");
        }

        if (!error.isEmpty()) {
            throw new BadRequestException(error.toString());
        }
    }
}
