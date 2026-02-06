package org.example.Exception;

public class InvalidInputException extends EntityNotFoundException{
    public InvalidInputException(String message){
        super(message);
    }



}
