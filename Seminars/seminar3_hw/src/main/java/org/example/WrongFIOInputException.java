package org.example;

public class WrongFIOInputException extends Exception{
    private String badString;

    public WrongFIOInputException(String message, String badString) {
        super(message);
        this.badString = badString;
    }

    public String getBadString() {
        return badString;
    }
}
