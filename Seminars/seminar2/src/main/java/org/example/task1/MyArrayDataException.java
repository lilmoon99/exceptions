package org.example.task1;

public class MyArrayDataException extends CustomArrayException{
    public MyArrayDataException(String message, int x, int y) {
        super(message, x, y);
    }

    public MyArrayDataException(String message, Throwable cause, int x, int y) {
        super(message, cause, x, y);
    }
}
