package org.example.task2;

import java.io.IOException;

public class CloseCounterException extends IOException {
    public CloseCounterException(String message) {
        super(message);
    }
}
