package ru.mts.medhack2019.shared.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
