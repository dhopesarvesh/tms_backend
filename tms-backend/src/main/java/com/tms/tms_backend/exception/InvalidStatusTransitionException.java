package com.tms.tms_backend.exception;

public class InvalidStatusTransitionException  extends  Exception{
    public InvalidStatusTransitionException(String message){
        super(message);
    }
}
