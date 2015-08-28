package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        int sum = 0;
        while (i==0)
        {
            String s = reader.readLine();
            if (!s.equals("сумма"))
                sum += Integer.parseInt(s);
            else
                i = 1;
        }
        System.out.println(sum);
    }
}
