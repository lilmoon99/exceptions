package org.example.task2;

public class Program {
    public static void main(String[] args) {

        try (Counter counter = new Counter(1000)){
            counter.add();
            counter.add();
            counter.add();
            System.out.println(counter.getCounter());
        }catch (CloseCounterException e){
            System.out.println(e.getMessage());
        }
    }
}