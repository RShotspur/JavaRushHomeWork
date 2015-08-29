package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character> glasnue = new ArrayList<Character>();
        ArrayList<Character> soGlasnue = new ArrayList<Character>();
        String sLine = reader.readLine();
        char[] charArray  = sLine.toCharArray();
        for (int i = 0; i < charArray.length; i++)
        {
            if(!(charArray[i] == ' ')){
                if(isVowel(charArray[i])){
                    glasnue.add(charArray[i]);
                } else {
                    soGlasnue.add(charArray[i]);
                }

            }

        }
        for (char aChar : glasnue){
            System.out.print(aChar + " ");
        }
        System.out.println();
        for (char aChar : soGlasnue){
            System.out.print(aChar + " ");
        }

    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
