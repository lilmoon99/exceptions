package org.example;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class CustomParser {
    private String input;
    private Map<String, Integer> fieldAndIndex;
    private String[] fields;

    public CustomParser(String input) {
        this.input = input;
    }

    public String[] parse() throws NullPointerException {
        try {
            checkDelimiter();
        } catch (WrongDelimiterException e) {
            System.out.println(e.getMessage());
        }
        initFieldsListAndMap();
        boolean isBadInfo = false;
        String[] array = this.input.split(" ");
        if (array.length != this.fields.length) {
            try {
                throw new InputInfoCountException("Вы ввели неправильное количество полей", array.length);
            } catch (InputInfoCountException e) {
                System.out.println(e.getMessage() + ": " + e.getInputLength());
                isBadInfo = true;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || i == 1 || i == 2) {
                try {
                    checkFIO(array[i]);
                } catch (WrongFIOInputException e) {
                    System.out.println(e.getMessage() + ": " + e.getBadString());
                    isBadInfo = true;
                }
            }
            if (i == 3) {
                try {
                    checkDateOfBirth(array[i]);
                } catch (WrongDateOfBirthInputException e) {
                    System.out.println(e.getMessage() + ": " + e.getWrongDate());
                    isBadInfo = true;
                }
            }
            if (i == 4) {
                try {
                    checkPhoneNumber(array[i]);
                }catch (WrongNumberInputException e){
                    System.out.println(e.getMessage() + " :"+ e.getBadPhoneNumber());
                    isBadInfo = true;
                }
            }
            if (i == 5) {
                try {
                    checkGender(array[i]);
                } catch (WrongGenderInputException e) {
                    System.out.println(e.getMessage() + ": " + e.getGender());
                    isBadInfo = true;
                }
            }

            if (isBadInfo) {
                return null;
            }

        }
        return array;
    }

    private void checkDateOfBirth(String date) throws WrongDateOfBirthInputException {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        format.setLenient(false);
        try {
            format.parse(date);
        } catch (ParseException e) {
            throw new WrongDateOfBirthInputException("\"Вы ввели неправильную дату.", e, date);
        }
    }

    private void checkDelimiter() throws WrongDelimiterException {
        CharSequence[] delimiters = {",", "/", "'", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "=", "+", "\"", "№", ";", ":", "?", "_"};
        for (CharSequence delimiter : delimiters) {
            if (this.input.contains(delimiter)) {
                throw new WrongDelimiterException("Нужно использовать пробел для разделения строк!");
            }
        }
    }

    private void checkFIO(String line) throws WrongFIOInputException {
        CharSequence[] badCharacters = {",", "/", "'", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "=", "+", "\"", "№", ";", ":", "?", "_", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        for (CharSequence badCharacter : badCharacters) {
            if (line.contains(badCharacter)) {
                throw new WrongFIOInputException("Неправильный формат ФИО: ", line);
            }
        }
    }

    private void initFieldsListAndMap() {
        this.fields = new String[]{"surname", "name", "patronymic", "dateOfBirth", "phoneNumber", "gender"};
//    for(int i = 0;i < this.fields.length;i++){
//        this.fieldAndIndex.put(this.fields[i],i);
//    }
    }

    private void checkPhoneNumber(String phoneNumber) throws WrongNumberInputException {
        try {
            long parsedPhoneNumber = Long.parseLong(phoneNumber);
            if (parsedPhoneNumber < 0){
//            throw new NumberFormatException("Номер не может быть отрицательным.");
                throw new WrongNumberInputException("Номер не может быть отрицательным.",phoneNumber);
            }
        }catch (NumberFormatException e){
            throw new WrongNumberInputException("Вы ввели невалидный номер", e, phoneNumber);
        }
    }

    private void checkGender(String gender) throws WrongGenderInputException {
        if (!gender.equals("m") && !gender.equals("f")) {
            throw new WrongGenderInputException("Вы ввели неправильный пол", gender);
        }
    }

    private String createSurnameFile(String surname) {
        String pathName = "Seminars/seminar3_hw/src/main/java/org/example/" + surname + ".txt";
        File file = new File(pathName);
        try {
            if (!file.isFile()){
                file.createNewFile();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return pathName;
    }

    public void WriteToFile(String[] input){
        String path = createSurnameFile(input[0]);
        StringBuilder standard = new StringBuilder();
        try (FileWriter fileWriter = new FileWriter(path,true);){
            for (String arg: input) {
                standard.append("<").append(arg).append(">");
            }
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(standard.toString() + "\n");
            bw.close();
            System.out.println("Успешно сохранено в файл: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
