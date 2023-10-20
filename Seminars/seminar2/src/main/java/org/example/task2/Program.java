package org.example.task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Анна=4
 * Елена=5
 * Марина=6
 * Владимир=?
 * Константин=?
 * Иван=4
 * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap, если
 * студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных, если сохранено
 * значение ?, заменить его на соответствующее число.Если на каком-то месте встречается символ, отличный от
 * числа или ?, бросить подходящее исключение.Записать в тот же файл данные с замененными символами ?.
 */
public class Program {
    public static void main(String[] args) {
        prepareFile();

    }

    static void prepareFile() {
        try(FileWriter fileWriter = new FileWriter("names.txt")) {
            fileWriter.write("Анна=4\n");
            fileWriter.write("Елена=5\n");
            fileWriter.write("Марина=6\n");
            fileWriter.write("Владимир=8\n");
            if (new Random().nextInt(2) == 0) {
                throw new Exception();
            }
            fileWriter.write("Константин=10\n");
            fileWriter.write("Иван=4\n");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void prepareFile_old() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("names.txt");
            fileWriter.write("Анна=4\n");
            fileWriter.write("Елена=5\n");
            fileWriter.write("Марина=6\n");
            fileWriter.write("Владимир=8\n");
            if (new Random().nextInt(2) == 0) {
                throw new Exception();
            }
            fileWriter.write("Константин=10\n");
            fileWriter.write("Иван=4\n");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
