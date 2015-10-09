package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String [] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String afterQuestionMark = url.substring(url.indexOf("?")+1);
        String [] tokens = afterQuestionMark.split("(\\&+)|(\\?+)");

        ArrayList<String> objList = new ArrayList<String>();
        Pattern objMutch = Pattern.compile("^obj=.*");
        for(String a:tokens){
            if(!a.equals("")){
                Matcher matcher = objMutch.matcher(a);
                if(matcher.find()){ objList.add(a.substring(a.indexOf("=")+1)); }
                if(a.contains("=")){ System.out.print(a.substring(0,(a.indexOf("="))) +" "); }
                else {System.out.print(a+" ");}
            }
        }

        Pattern doublePattern = Pattern.compile("[0-9.]");
        Pattern stringPattern = Pattern.compile("[A-Za-z]");

        System.out.println();
        for(String a:objList){
            Matcher matcher = stringPattern.matcher(a);
            Matcher matcher1 = doublePattern.matcher(a);
            if(matcher.find()){alert(a);}
            else  if(matcher1.find()){alert(Double.parseDouble(a));}
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

//My code, works correctly, but smth not correct for validator

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        //add your code here
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String s = reader.readLine();
//        s = s.substring(s.indexOf('?') + 1);
//        ArrayList<String> listOfPairs = new ArrayList<String>();
//
//        int count = 1;
//        char[] listOfChars = s.toCharArray();
//        for (char temp : listOfChars){
//            if ('&' == temp){
//                count++;
//            }
//        }
//        if (count == 1){
//            listOfPairs.add(s.substring(0));
//        } else {
//            for (int i = 0; i < count; i++)
//            {
//                if (i == count - 1){
//                    listOfPairs.add(s.substring(0));
//                } else {
//                    listOfPairs.add(s.substring(0, s.indexOf('&')));
//                    s = s.substring(s.indexOf('&') + 1);
//                }
//            }
//        }
//
//        ArrayList<String> params = new ArrayList<String>();
//        ArrayList<String> valueis = new ArrayList<String>();
//        int countObj = 0;
//        for(String pair : listOfPairs){
//            if (pair.contains("=")){
//                params.add(pair.substring(0, pair.indexOf('=')));
//                if ("obj".equals(pair.substring(0, pair.indexOf('=')))){
//                    valueis.add(pair.substring(pair.indexOf('=') + 1));
//                    countObj++;
//                }
//            }
//            else
//            {
//                params.add(pair);
//            }
//        }
//
//        for (int i = 0; i < params.size()-1; i++)
//        {
//            System.out.print(params.get(i) + " ");
//        }
//        System.out.print(params.get(params.size()-1));
//
//        if (countObj > 0){
//            System.out.println();
//            for (String value : valueis){
//                if (value.contains(".")){
//                    alert(Double.parseDouble(value));
//                } else {
//                    alert(value);
//                }
//            }
//        }
//
//
//    }
//
//    public static void alert(double value) {
//        System.out.println("double " + value);
//    }
//
//    public static void alert(String value) {
//        System.out.println("String " + value);
//    }
//}
