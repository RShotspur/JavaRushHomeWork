package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код
        ArrayList<String> tempString = new ArrayList<String>();
        ArrayList<Integer> tempInt = new ArrayList<Integer>();
        boolean[] bollArray = new boolean[array.length];
        for (int i = 0; i < array.length; i++)
        {
            if(isNumber(array[i])){
                tempInt.add(Integer.parseInt(array[i]));
                bollArray[i] = true;
            } else {
                tempString.add(array[i]);
                bollArray[i] = false;
            }

        }
        for (int i = 0; i < tempInt.size(); i++)
        {
            int temp;
            for (int j = i; j < tempInt.size(); j++)
            {
                if (tempInt.get(i) < tempInt.get(j)){
                    temp = tempInt.get(i);
                    tempInt.set(i, tempInt.get(j));
                    tempInt.set(j, temp);
                }
            }
        }
        for (int i = 0; i < tempString.size(); i++)
        {
            String temp;
            for (int j = i; j < tempString.size(); j++)
            {
                if (isGreaterThen(tempString.get(i), tempString.get(j))){
                    temp = tempString.get(i);
                    tempString.set(i, tempString.get(j));
                    tempString.set(j, temp);
                }
            }
        }
        int countInt = 0;
        int countString = 0;
        for (int i = 0; i < bollArray.length; i++)
        {
            if (bollArray[i]){
                array[i] = tempInt.get(countInt).toString();
                countInt++;
            }
            else {
                array[i] = tempString.get(countString);
                countString++;
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
