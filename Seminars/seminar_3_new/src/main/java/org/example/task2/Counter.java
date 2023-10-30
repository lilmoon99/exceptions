package org.example.task2;

public class Counter implements AutoCloseable{

    private int counter;
    private boolean isOpen;

    public int getCounter() {
        return counter;
    }

    public int add() throws CloseCounterException {
        if (!isOpen){
            throw new CloseCounterException("Счётчик закрыт.");
        }
        return ++counter;
    }

    public Counter(int counter) {
        this.counter = counter;
        isOpen = true;
    }

    public Counter() {
        isOpen = true;
    }

    public void closeCounter(){
        isOpen = false;
    }

    @Override
    public void close() {
        closeCounter();
    }
}
