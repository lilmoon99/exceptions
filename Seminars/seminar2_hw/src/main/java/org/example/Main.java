package org.example;
public class Main {
    public static void main(String[] args) {
//        String input = "Ivan";
//        float res = IsFloat.isFloat(input);
//        System.out.println(res);

//        int[] intArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 0, 9};
//        int d = 0;
//        System.out.println(Expr.expr(intArray, d));

//        double result = Expr2.expr(90,0);
//        System.out.println(result);
        char a = 'c';
        try {
            String result = Expr3.expr(a);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

class IsFloat {
    public static float isFloat(String input) {
        try {
            float temp = Float.parseFloat(input);
            return temp;
        } catch (NumberFormatException e) {
            System.out.println("Your input is not a float number. Please, try again.");
            return Float.NaN;
        }
    }
}

class Expr {

    public static double expr(int  [] intArray, int d) {
        // Введите свое решение ниже
        int nominator;
        double result = Double.NaN;
        try {
            int temp = intArray[8];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("It's not possible to evaluate the expression - intArray[8] / d as there is no 8th element in the given array.");
            return Double.NaN;
        }
        try {
            result = (double) intArray[8] / d;
            if (result == Double.POSITIVE_INFINITY || d == 0){
                throw new ArithmeticException();
            }
            else {
                nominator = intArray[8];
                System.out.printf("intArray[8] / d = %d / %d = %s",nominator,d,result);
                System.out.println();
                return result;
            }

        } catch (ArithmeticException e) {
            System.out.println("It's not possible to evaluate the expression - intArray[8] / d as d = 0.");
            return Double.NaN;
        }
    }
}

class Expr2 {

    public static double expr(int a, int b) {
        // Введите свое решение ниже
        printSum(a,b);
        try{
            double result = (double) a/b;
            if (result == Double.POSITIVE_INFINITY || b == 0) throw new ArithmeticException();
            return result;
        } catch (ArithmeticException e){
            return 0;
        }
    }

    public static void printSum(int a, int b) {
        // Введите свое решение ниже
        System.out.println(a+b);
    }
}

class Expr3 {
    public static String expr(char a) throws Exception {
// Введите свое решение ниже
    if (a == ' '){
        throw new MyCustomException("Empty string has been input.");
    }
    return String.format("Your input was - %c",a);
    }
}

class MyCustomException extends Exception{
    public MyCustomException(String message) {
        super(message);
    }


}