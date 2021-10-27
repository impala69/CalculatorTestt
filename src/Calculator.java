import java.io.EOFException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Calculator {
    public static final int ARABIC = 0; // проверка на арабское число
    public static final int MAX_VALUE = 10;
    public static final int MIN_VALUE = 0;


    public static void main(String[] args) throws EOFException {
        System.out.println("Введите операцию");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] array = input.split(" ");

        String operation = array[1];
        String num1 = array [0];
        String num2 = array [2];

        String result;
        if (getCalcWay(num1,num2)==ARABIC){
            result = calcArabic(num1,num2,operation);
        }else {
            result = calcRoman(num1,num2,operation);
        }
        System.out.println(result);

    }

    public static int getCalcWay(String num1, String num2){
        Set<String>romanSymbols = new HashSet<String>();
        romanSymbols.add("I");
        romanSymbols.add("V");
        romanSymbols.add("X");
        romanSymbols.add("L");
        romanSymbols.add("C");
        romanSymbols.add("D");
        romanSymbols.add("M");

       int i1 = romanSymbols.contains(String.valueOf(num1.charAt(0)))?1:0;
       int i2 = romanSymbols.contains(String.valueOf(num1.charAt(0)))?1:0;
       int result=i1+i2;
       if (result == 1){
           throw new RuntimeException("введите два римским или два арабских числа");
       }
       return result;
    }

    private static int calc(int num1, int num2, String operation){
        RangeNumbers(num1,num2);
        switch (operation){
            case "+":
                return num1 + num2;
            case  "-":
            return num1 - num2;
            case "/":
            return num1 / num2;
            case "*":
            return  num1 * num2;
            default:
                throw new IllegalArgumentException("Введите правильно операцию(калькулятор может умножить/поделить/вычесть/прибавить");

        }
    }
    public  static  String calcArabic(String num1,String num2,String operation){
        return String.valueOf(calc(Integer.parseInt(num1),Integer.parseInt(num2),operation));
    }
    public  static  String calcRoman(String num1,String num2,String operation) {
        return Convertor.intToRoman(calc(Convertor.romanToInt(num1),Convertor.romanToInt(num2),operation));}


    private static void RangeNumbers(int num1, int num2){
        if ((num1 > MAX_VALUE || num1 < MIN_VALUE) ||(num2 > MAX_VALUE || num2 < MIN_VALUE)){
            throw new IllegalArgumentException("Значение не находится в радиусе от 1 до 10");
        }}
}


