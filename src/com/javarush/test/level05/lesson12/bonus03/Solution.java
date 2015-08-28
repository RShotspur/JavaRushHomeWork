package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] mas = new int[n];
        int maximum;

        for (int i=n-1; i>=0; i--){
            mas[i]=Integer.parseInt(reader.readLine());
        }

        maximum = mas[0];

        for (int j=n-1; j>0; j--){
            maximum = maximum>=mas[j]?maximum:mas[j];
        }

        //напишите здесь ваш код




        System.out.println(maximum);
    }
}
