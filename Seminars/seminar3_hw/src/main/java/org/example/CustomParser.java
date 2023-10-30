package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class CustomParser {
    private String input;
    private Map<String,Integer> fieldAndIndex;
    private String[] fields;

    public CustomParser(String input) {
        this.input = input;
    }

    public String[] parse() throws InputInfoCountException{
        try {
            checkDelimiter();
        }catch (WrongDelimiterException e){
            System.out.println(e.getMessage());
        }
        initFieldsListAndMap();
        String[] array = this.input.split(" ");
        if (array.length != this.fields.length){
            throw new InputInfoCountException("Вы ввели неправильное количество полей",array.length);
        }
        for (int i =0;i < array.length;i++) {
            if (i == 0 || i == 1 || i == 2) {
                try {
                    checkFIO(array[i]);
                } catch (WrongFIOInputException e) {
                    System.out.println(e.getMessage() + e.getBadString());
                }
            }
            if (i == 3) {
                try {
                    checkDateOfBirth(array[i]);
                } catch (WrongDateOfBirthInputException e){
                    System.out.println(e.getMessage() + e.getWrongDate());
                }
            }

        }
        return array;
    }

    private void checkDateOfBirth(String date) throws WrongDateOfBirthInputException {
        DateFormat[] formats = {new SimpleDateFormat("dd.MM.yyyy"), new SimpleDateFormat("dd/MM/yyyy"), new SimpleDateFormat("dd-MM-yyyy")};
        //TODO
        //if goodParseCounter > 0 don't throw exception
        for (DateFormat format : formats) {
            format.setLenient(false);
            try {
                format.parse(date);
            } catch (ParseException e) {
                throw new WrongDateOfBirthInputException("\"Вы ввели неправильную дату.",e,date);
            }
        }
//        String[] splitted


    }

    private void checkDelimiter() throws WrongDelimiterException{
        CharSequence[] delimiters = {",", "/", "'", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "=", "+", "\"", "№", ";", ":", "?", "_"};
        for (CharSequence delimiter :delimiters){
            if (this.input.contains(delimiter)){
                throw new WrongDelimiterException("Нужно использовать пробел для разделения строк!");
            }
        }
    }
    private void checkFIO(String line) throws WrongFIOInputException {
        CharSequence[] badCharacters = {",", "/", "'", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "=", "+", "\"", "№", ";", ":", "?", "_","1","2","3","4","5","6","7","8","9","0"};
        for (CharSequence badCharacter:badCharacters) {
            if (line.contains(badCharacter)){
                throw new WrongFIOInputException("Неправильный формат ФИО: ",line);
            }
        }
    }

    private void initFieldsListAndMap(){
    this.fields = new String[]{"surname","name","patronymic","dateOfBirth","phoneNumber","gender"};
//    for(int i = 0;i < this.fields.length;i++){
//        this.fieldAndIndex.put(this.fields[i],i);
//    }
    }
}
