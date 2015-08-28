package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = new int[5];
        for(int i=0; i<numbers.length; i++)
            numbers[i] = Integer.parseInt(reader.readLine());

        for(int i=0; i<numbers.length; i++){
            for (int j = i; j < numbers.length; j++){
                if (numbers[j]<numbers[i]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
            System.out.println(numbers[i]);
        }
    }
}
