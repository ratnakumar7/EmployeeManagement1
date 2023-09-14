package com.example.EmployeeManagement.exception;

public class EmployeeNotFound extends RuntimeException{
    private String message;

    public EmployeeNotFound(String message) {
        super(message);
        this.message = message;
    }
}
