package com.javarush.test.level15.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* Факториал
Написать метод, который вычисляет факториал - произведение всех чисел от 1 до введенного числа включая его.
Пример: 4! = factorial(4) = 1*2*3*4 = 24
1. Ввести с консоли число меньше либо равно 150.
2. Реализовать функцию  factorial.
3. Если введенное число меньше 0, то вывести 0.
0! = 1
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        if (n < 0) {
            return "0";
        }
        else if (n == 0) return "1";
        else {
            BigInteger ret = BigInteger.ONE;
            for (int i = 1; i <= n; ++i) ret = ret.multiply(BigInteger.valueOf(i));
            return ret.toString();
        }
    }
}

//My code isn't valid again(((((

//    public static String factorial(int n) {
//        //add your code here
//        if (n < 0) {
//            return "0";
//        } else if (n == 0){
//            return "1";
//        } else {
//            double sum = (double)1;
//            for (int i = 1; i < n + 1; i++)
//            {
//                sum *= (double)i;
//            }
//            return toString(sum);
//        }
//
//
//
//    }
//
//    public static String toString(double num){
//        String number = Double.toString(num);
//        if (number.contains("E")){
//            String beforePoint;
//            String afterPoint;
//            int afterE;
//            String result;
//
//            beforePoint = number.substring(0, number.indexOf('.'));
//            afterPoint = number.substring(number.indexOf('.') + 1, number.indexOf('E'));
//            afterE = Integer.parseInt(number.substring(number.indexOf('E') + 1));
//
//            result = beforePoint + afterPoint;
//            afterE = afterE - afterPoint.length();
//            for (int i = 0; i < afterE; i++)
//            {
//                    result += "0";
//            }
//
//            return result;
//        } else {
//            return number.substring(0, number.indexOf('.'));
//        }
//    }
//}
