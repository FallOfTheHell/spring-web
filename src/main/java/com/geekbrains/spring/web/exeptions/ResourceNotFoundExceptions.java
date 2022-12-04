package com.geekbrains.spring.web.exeptions;

public class ResourceNotFoundExceptions extends RuntimeException{
    public ResourceNotFoundExceptions(String message) {
        super(message);
    }
}
