package com.wf.ProfileBestMatch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceExsitsExeption extends RuntimeException {

    public ResourceExsitsExeption(String message) {
        super(message);
    }

    public ResourceExsitsExeption(String message, Throwable cause) {
        super(message, cause);
    }

}
