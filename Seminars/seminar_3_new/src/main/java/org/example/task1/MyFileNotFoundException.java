package org.example.task1;

public class MyFileNotFoundException extends Exception{
    private final String filename;

    public MyFileNotFoundException(String message, Throwable cause, String filename) {
        super(message, cause);
        this.filename = filename;
    }

    public MyFileNotFoundException(String message, String filename) {
        super(message);
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
