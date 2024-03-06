package com.wf.ProfileBestMatch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
public class FileFormatUnSupportedException extends RuntimeException {

    public FileFormatUnSupportedException(String message) {
        super(message);
    }

}
