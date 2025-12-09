package com.tms.tms_backend.exception;

public class LockAlreadyBookedException extends RuntimeException{
    public LockAlreadyBookedException(String message){
        super(message);
    }

    public LockAlreadyBookedException(String message, Throwable cause){
        super(message, cause);
    }
}
