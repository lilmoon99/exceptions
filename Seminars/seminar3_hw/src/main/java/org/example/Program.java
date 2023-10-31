package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        String[] array = new String[0];

        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("""
                Введите данные, разделенные пробелом.
                Фамилия Имя Отчество датарождения номертелефона пол
                Форматы данных:
                фамилия, имя, отчество - строки
                датарождения - строка формата dd.mm.yyyy
                номертелефона - целое беззнаковое число без форматирования
                пол - символ латиницей f или m.""");
                String input = scanner.nextLine();
                CustomParser customParser = new CustomParser(input);

                array = customParser.parse();
                if (array != null){
                    customParser.WriteToFile(array);
                }
                System.out.println("""
                        Продолжаем?
                        1 - Да
                        2 - Нет
                        """);
                String command = scanner.nextLine();
                if ("2".equals(command)) {
                    System.out.println("До свидания!");
                    break;
                }

            }catch (NullPointerException e){
                System.out.println("Невозможно извлечь информацию.");
            }
        }


       }

}
