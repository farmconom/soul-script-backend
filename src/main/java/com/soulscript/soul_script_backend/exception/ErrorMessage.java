package com.soulscript.soul_script_backend.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ErrorMessage {
    // Getters and setters
    private int status;
    private Date timestamp;
    private String message;
    private String description;

    public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
        this.status = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

}
