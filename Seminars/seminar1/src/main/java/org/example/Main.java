package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int [] a = new int[]{12, 8, 16};
        int [] b = new int[]{4, 2, 4};
        Answer ans = new Answer();
        String itresume_res = Arrays.toString(ans.divArrays(a, b));
        System.out.println(itresume_res);
    }
}

class Answer {
    public int[] subArrays(int[] a, int[] b) {
        int[] answer;
        if (a.length != b.length) {
            return new int[1];
        } else {
            answer = new int[a.length];
        }

        for (int i = 0; i < a.length;i++){
            answer[i] = a[i] - b[i];
        }
        return answer;
    }
    public int[] divArrays(int[] a, int[] b){
        // Введите свое решение ниже
        int[] answer;
        if (a.length != b.length) {
            return new int[1];
        } else {
            answer = new int[a.length];
        }

        for (int i = 0; i < a.length;i++){
            answer[i] = a[i] / b[i];
        }
        return answer;

    }
}