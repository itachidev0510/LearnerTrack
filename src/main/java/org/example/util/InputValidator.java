package org.example.util;

import org.example.Exception.InvalidInputException;

public class InputValidator {
    public void validateId(int id) throws InvalidInputException {
        if(id<1){
            throw new InvalidInputException("Invalid Student ID");

        }
        else
            return;

    }
    public  void ValidateLastName(String lastName) throws InvalidInputException {
        if(lastName==null || lastName.isEmpty()||lastName.isBlank()){
            throw new InvalidInputException("Invalid Student Last Name");
        }
        else
            return ;

    }
    public void validateFirstName(String firstName) throws InvalidInputException {
        if(firstName==null || firstName.isEmpty()||firstName.isBlank()){
            throw new InvalidInputException("Invalid Student First Name");
        }
    }
    public void validateEmail(String email) throws InvalidInputException {
        if(email==null || email.isEmpty()||email.isBlank()){
            throw new InvalidInputException("Invalid Student Email");
        }
    }
    public void validateCourseName(String courseName) throws InvalidInputException {
        if(courseName==null || courseName.isEmpty()||courseName.isBlank()){
            throw new InvalidInputException("Invalid Student CourseName");
        }
    }
    public void ValidateCourseweekDuration(int courseweekDuration) throws InvalidInputException {
        if(courseweekDuration<=0){
            throw new InvalidInputException("Invalid Student Courseweek Duration");
        }
    }
}
