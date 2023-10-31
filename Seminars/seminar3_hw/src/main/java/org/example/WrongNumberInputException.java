package org.example;

public class WrongNumberInputException extends Exception{
    private String badPhoneNumber;

    public WrongNumberInputException(String message, String badPhoneNumber) {
        super(message);
        this.badPhoneNumber = badPhoneNumber;
    }

    public WrongNumberInputException(String message, Throwable cause, String badPhoneNumber) {
        super(message, cause);
        this.badPhoneNumber = badPhoneNumber;
    }

    public String getBadPhoneNumber() {
        return badPhoneNumber;
    }
}
