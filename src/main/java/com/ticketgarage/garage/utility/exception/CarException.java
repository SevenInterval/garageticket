package com.ticketgarage.garage.utility.exception;

public class CarException extends Exception {

    private String errorMessage;

    public CarException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
