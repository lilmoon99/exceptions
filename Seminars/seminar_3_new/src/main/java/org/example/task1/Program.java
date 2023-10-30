package org.example.task1;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Program {
    public static void main(String[] args) {
//        try {
//            task1();
//        }catch (DivideByZeroException e){
//            System.out.println(e.getMessage());
//        }

//        try {
//            task2(new String[]{"AA","BB","CC","AB","BA"},3);
//            System.out.println();
//            task2(new String[]{"AA","BB","CC",null,"BA"},3);
//        }catch (NullElementArrayException e){
//            System.out.println(e.getMessage());
//            System.out.println("Индекс элемента: "+ e.getIndex());
//        }catch (ArrayIndexOutOfBoundsException | NullPointerException e){
//            System.out.println(e.getMessage());
//        }
        try {
            task3("F:/AA/BB/CC.txt");
        }catch (MyFileNotFoundException e){
            System.out.printf("%s\nНаимнование файла: %s\n",e.getMessage(),e.getFilename());
        }
    }

    /**
     * Первая подзадача. Деление числа на 0.
     * @throws DivideByZeroException Ошибка деления на 0
     */
    static void task1() throws DivideByZeroException{
        try {
            int a = 10/0;

        }catch (ArithmeticException e){
            throw new DivideByZeroException("Ошибка деления числа на 0.");
        }
    }

    /**
     * Получить значение элемента массива по индексу
     * @param array массив
     * @param index индекс элемента массива
     * @throws NullElementArrayException элемент массива не проинициализирован
     */
    static void task2(String[] array,int index) throws NullElementArrayException{
        if (array[index] == null){
            throw new NullElementArrayException("Элемент массива не проинициализирован.",index);
        }
        System.out.printf("Значение элемента массива: %s",array[index]);
    }


    static void task3(String filename) throws MyFileNotFoundException {
        try (FileReader fileReader = new FileReader(filename)){

        }catch (FileNotFoundException e){
            throw new MyFileNotFoundException("Файл не найден.",filename);
        }catch (Exception e){

        }
    }
}
