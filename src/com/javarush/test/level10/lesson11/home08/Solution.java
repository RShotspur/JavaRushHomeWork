package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;


/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String>[] list = new ArrayList[3];
        for (int i = 0; i < 3; i++)
        {
            list[i] = new ArrayList<String>();
            list[i].add("Data " + i);
            list[i].add("Data2 " + i);
            list[i].add("Data3 " + i);
            list[i].add("Data4 " + i);
            list[i].add("Data5 " + i);
        }

        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}