package com.java.circle.practice.api.exception;

public class CarException extends RuntimeException {
    public CarException() {
        super();
    }
    public CarException(String s) {
        super(s);
    }
    public CarException(String s, Throwable throwable) {
        super(s, throwable);
    }
    public CarException(Throwable throwable) {
        super(throwable);
    }
}
