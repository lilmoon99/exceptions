package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {
    public static void main(String[] args) {
        System.out.println("Введите данные в произвольном порядке, разделенные пробелом\n" +
                "Фамилия Имя Отчество датарождения номертелефона пол");

        String input = "Шамсуллин Айнур Дамирович 25.11.2999 89911944602 m";
        CustomParser customParser = new CustomParser(input);
        String[] array = new String[0];
        try {
            array = customParser.parse();
        } catch (InputInfoCountException e) {
            throw new RuntimeException(e);
        }
        for (String o : array) {
            System.out.println(o);
        }

       }

}
