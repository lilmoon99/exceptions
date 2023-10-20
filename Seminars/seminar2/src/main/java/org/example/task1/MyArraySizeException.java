package org.example.task1;

public class MyArraySizeException extends CustomArrayException{

    public MyArraySizeException(String message, int x, int y) {
        super(message, x, y);
    }

    public MyArraySizeException(String message, Throwable cause, int x, int y) {
        super(message, cause, x, y);
    }
}
