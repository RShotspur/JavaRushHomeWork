package com.javarush.test.level07.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Нужно добавить в программу новую функциональность
Задача:  Программа вводит строки, пока пользователь не введёт пустую строку (нажав enter). Потом она конвертирует строки в верхний регистр (Мама превращается в МАМА) и выводит их на экран.
Новая задача: Программа вводит строки, пока пользователь не введёт пустую строку (нажав enter). Потом программа строит новый список. Если в строке чётное число букв, строка удваивается, если нечётное – утраивается.
Пример ввода:
Кот
Коты
Я
Пример вывода:
Кот Кот Кот
Коты Коты
Я Я Я
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> listUpperCase = new ArrayList<String>();
        for (String s : list)
        {
            if (s.length() % 2 == 0){
                listUpperCase.add(s);
                listUpperCase.add(s);
            }
            else{
                listUpperCase.add(s);
                listUpperCase.add(s);
                listUpperCase.add(s);
            }


        }

        System.out.print(listUpperCase.get(0) + " ");

        for (int i = 1; i < listUpperCase.size(); i++)
        {
            if (listUpperCase.get(i).equals(listUpperCase.get(i-1))) System.out.print(listUpperCase.get(i) + " ");
            else {
                System.out.println();
                System.out.print(listUpperCase.get(i)+" ");
            }
        }
    }
}
