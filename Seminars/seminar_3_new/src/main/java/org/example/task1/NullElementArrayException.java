package org.example.task1;

public class NullElementArrayException extends NullPointerException {
    private final int index;

    public NullElementArrayException(String s, int index) {
        super(s);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
