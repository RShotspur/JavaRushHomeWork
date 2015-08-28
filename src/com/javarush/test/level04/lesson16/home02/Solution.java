package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x1 = Integer.parseInt(reader.readLine());
        int x2 = Integer.parseInt(reader.readLine());
        int x3 = Integer.parseInt(reader.readLine());

        if ((x1>x2 && x1<x3) || (x1<x2 && x1>x3))
            System.out.println(x1);
        else if ((x2>x1 && x2<x3) || (x2<x1 && x2>x3))
            System.out.println(x2);
        else
            System.out.println(x3);
    }
}
