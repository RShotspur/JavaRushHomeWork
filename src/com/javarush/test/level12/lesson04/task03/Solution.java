package com.javarush.test.level12.lesson04.task03;

/* Пять методов print с разными параметрами
Написать пять методов print с разными параметрами.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    //Напишите тут ваши методы
    public static void print(int x){
        System.out.println(x);
    }
    public static void print(Integer x){
        System.out.println(x);
    }
    public static void print(long x){
        System.out.println(x);
    }
    public static void print(boolean x){
        System.out.println(x);
    }
    public void print(String x){
        System.out.println(x);
    }
}
