package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{

    public static void main(String[] args)
    {
        System.out.println(isDateOdd("JANUARY 1 2015"));
    }

    public static boolean isDateOdd(String date)
    {
        Date temp = new Date(date);
        temp.setMonth(0);
        temp.setDate(1);
        Date nowDate = new Date(date);
        long tempLong = nowDate.getTime() - temp.getTime();
        long day = 24*60*60*1000;
        int countDay = (int)(tempLong/day);

        if ((countDay%2) == 0) return true;
        else return false;

    }

}

