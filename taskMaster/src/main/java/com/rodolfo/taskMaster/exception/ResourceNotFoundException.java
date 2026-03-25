package com.rodolfo.taskMaster.exception;


//cuando algo no existe en la BD
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
