package com.myprojects.spring_transatcional.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PaymentCardException extends RuntimeException {
    public PaymentCardException(String message) {
        super(message);
    }
}
