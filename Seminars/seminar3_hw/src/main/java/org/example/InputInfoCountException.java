package org.example;

public class InputInfoCountException extends Exception {
    private int inputLength;

    public InputInfoCountException(String message, int inputLength) {
        super(message);
        this.inputLength = inputLength;
    }

    public int getInputLength() {
        return inputLength;
    }
}
