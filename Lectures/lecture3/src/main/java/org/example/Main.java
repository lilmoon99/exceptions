package org.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("someFile.txt");
             FileWriter writer = new FileWriter("test")
        ){
            while (reader.ready()){
                writer.write(reader.read());
            }
        }catch (RuntimeException | IOException e){
            System.out.println("catch exception" + e.getClass().getSimpleName());
        }
        System.out.println("Copy success!");
    }
}