package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        //напишите тут ваш код
        //create map for output result
        HashMap<Character, Integer> result = new HashMap<Character, Integer>();
        for (Character temp : alphabet){
            result.put(temp, 0);
        }

        //from ArrayList<String> to ArrayList<ArrayList<Character>>
        //create ArrayList<ArrayList<Character>> and full in it

        ArrayList<ArrayList<Character>> listArrayChar = new ArrayList<ArrayList<Character>>();
        char[] tempArray;
        for(String temp : list){
            tempArray = temp.toCharArray();
            ArrayList<Character> tempArrayChar = new ArrayList<Character>();
            for (int i = 0; i < tempArray.length; i++)
            {
                tempArrayChar.add(tempArray[i]);
            }
            listArrayChar.add(tempArrayChar);

        }

        //fill in result Map
        for (ArrayList<Character> listTemp : listArrayChar){
            for(Character charTemp : listTemp){
                //check is not full, not checked for symbols
                if(isNumber(charTemp.toString()) || charTemp.equals(' ')){
                    continue;
                }
                result.put(charTemp, result.get(charTemp) + 1);
            }
        }

        for (char charTemp : abcArray){
            System.out.println(charTemp + " " + result.get(charTemp));
        }
    }
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
