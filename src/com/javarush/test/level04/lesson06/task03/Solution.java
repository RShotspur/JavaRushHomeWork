package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[3];
        int[] num = new int[3];
        int[] numb = new int[3];
        for (int i=0; i<3; i++)
            str[i] = reader.readLine();
        for (int i=0; i<3; i++)
            num[i] = Integer.parseInt(str[i]);
        int a=num[0], b=num[1], c=num[2];
        if (a<b && a<c)
            numb[0] = a;
        else if (b<a && b<c)
            numb[0] = b;
        else
            numb[0] = c;
        if (a>b && a>c)
            numb[2] = a;
        else if (b>a && b>c)
            numb[2] = b;
        else
            numb[2] = c;
        numb[1] = (a+b+c)-(numb[0]+numb[2]);
        for (int i=2; i>=0; i--)
            System.out.println(numb[i]);

    }
}
