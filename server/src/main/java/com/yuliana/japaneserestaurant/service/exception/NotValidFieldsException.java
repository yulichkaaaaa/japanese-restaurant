package com.yuliana.japaneserestaurant.service.exception;

import org.springframework.validation.BindingResult;

public class NotValidFieldsException extends RuntimeException {
    private BindingResult bindingResult;

    /**
     * Constructs exception with given binding result.
     *
     * @param bindingResult the {@code BindingResult} object
     */
    public NotValidFieldsException(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    /**
     * Getter method of binding result.
     *
     * @return the {@code BindingResult} object
     */
    public BindingResult getBindingResult() {
        return bindingResult;
    }
}
