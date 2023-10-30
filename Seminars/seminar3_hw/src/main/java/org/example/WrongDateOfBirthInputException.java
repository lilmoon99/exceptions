package org.example;

public class WrongDateOfBirthInputException extends Exception{
    private String wrongDate;

    public WrongDateOfBirthInputException(String message, String wrongDate) {
        super(message);
        this.wrongDate = wrongDate;
    }

    public WrongDateOfBirthInputException(String message, Throwable cause, String wrongDate) {
        super(message, cause);
        this.wrongDate = wrongDate;
    }

    public String getWrongDate() {
        return wrongDate;
    }
}
