package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] str = new String[4];
            int[] num = new int[4];
            for (int i=0; i<4; i++)
                str[i] = reader.readLine();
            for (int j=0; j<4; j++)
                num[j] = Integer.parseInt(str[j]);
            if (num[0]>num[1] && num[0]>num[2] && num[0]>num[3])
                System.out.println(num[0]);
            else if (num[1]>num[2] && num[1]>num[3])
                System.out.println(num[1]);
            else if (num[2]>num[3])
                System.out.println(num[2]);
            else
                System.out.println(num[3]);
    }
}
