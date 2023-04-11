package com.bright.todomanagement.exception;

/*
 * @Project Name: todo-management
 * @Author: Okechukwu Bright Onwumere
 * @Created: 11/04/2023
 */


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
