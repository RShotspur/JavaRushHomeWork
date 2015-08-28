package com.javarush.test.level05.lesson12.home04;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

import java.util.Date;

public class Solution
{
    public static void main(String[] args)
    {
        Date date = new Date();
        System.out.printf("%1$td %1$tm %1$tY", date);
    }
}
