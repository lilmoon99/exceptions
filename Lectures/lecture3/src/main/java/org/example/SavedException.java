package org.example;

import java.io.IOException;

public class SavedException extends IOException {
    public SavedException(String message, Exception cause) {
        super(message, cause);
    }
}
