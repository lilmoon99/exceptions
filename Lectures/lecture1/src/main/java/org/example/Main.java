package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        System.out.println(getFileSize(new File("Lectures/lecture1/target/classes/org/example/Main.class")));
        System.out.println(divide(10,0));
//        a();
    }

    public static long getFileSize(File file) {
        if (!file.exists()) {
            return -1L;
        }
        return file.length();
    }

    public static int divide(int a1, int a2) {
        if (a2 == 0){
            throw new RuntimeException("Нельзя делить на 0!");
        }
        return a1 / a2;
    }

    public static void a() {
        b();
    }

    public static void b() {
        c();
    }

    public static void c() {
        int[] ints = new int[10];
        System.out.println(ints[1000]);
    }
}