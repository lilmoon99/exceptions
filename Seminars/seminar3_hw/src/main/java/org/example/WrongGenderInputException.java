package org.example;

public class WrongGenderInputException extends Exception{
    private String gender;

    public WrongGenderInputException(String message, String gender) {
        super(message);
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
