package org.example.task1;

import java.util.Random;

/**
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
 * При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 * должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
 * MyArrayDataException и вывести результат расчета.
 */

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            processArray();
        }
    }

    static void processArray() {
        try {
            System.out.println("Сумма всех элементов массива: " + processArrayInternal(generateArray()));
        }catch (MyArrayDataException e){
            System.out.printf("%s по индексу [%d][%d]\n",e.getMessage(),e.getX(),e.getY());
            e.printStackTrace();
        }catch (MyArraySizeException e){
            System.out.printf("%s требовалось 4*4, получили %d*%d\n",e.getMessage(),e.getX(),e.getY());
        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (Exception e){

        }

    }

    public static String[][] generateArray() {
        int add = random.nextInt(2);
        String[][] array = new String[4 + add][4 + add];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = Integer.toString(random.nextInt(10, 100));
            }
        }
        if (random.nextInt(3) == 0) {
            array[random.nextInt(array.length)][random.nextInt(array[0].length)] = "abc";
        }

        return array;
    }

    /**
     * @param array массив
     * @return сумма элементов
     * @throws MyArraySizeException Некорректный размер массива(4*4)
     * @throws MyArrayDataException Некорректный формат данных
     * @throws NullPointerException Массив должен существовать
     */
    static int processArrayInternal(String[][] array) throws MyArraySizeException, MyArrayDataException, NullPointerException {
        if (array == null) {
            throw new NullPointerException();
        }
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Некорректный размер массива", array.length, array[0].length);
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                sum += parseElement(array[i][j], i, j);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return sum;
    }

    /**
     * @param s значение элемента
     * @param x индекс элемента в массиве
     * @param y индекс элемента в массиве
     * @return пр
     * @throws MyArrayDataException Некорректный формат данных
     */
    static int parseElement(String s, int x, int y) throws MyArrayDataException {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Некорректный формат данных", e, x, y);
        }
    }
}