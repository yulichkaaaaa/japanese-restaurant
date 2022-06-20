package com.yuliana.japaneserestaurant.web.controller;

public class CustomResponse {
    private String errorMessage;

    public CustomResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public CustomResponse() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
