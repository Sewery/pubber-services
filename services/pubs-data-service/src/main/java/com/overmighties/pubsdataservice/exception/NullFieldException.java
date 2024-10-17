package com.overmighties.pubsdataservice.exception;

public class NullFieldException extends NullPointerException {
    private static final String BASE_MESSAGE = "Field %s in entity %s cannot be null";
    private Class<?> className;
    private String fieldName;
    public NullFieldException(Class<?> className, String fieldName){
        super(String.format(BASE_MESSAGE,fieldName, className.getSimpleName()));
    }
    public NullFieldException(String message){
        super(message);
    }
}
