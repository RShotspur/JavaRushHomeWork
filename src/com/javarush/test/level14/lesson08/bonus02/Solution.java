package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[2];
        int temp;
        int count = 0;
        while (true){
            if (count > 1){
                break;
            }
            temp = Integer.parseInt(reader.readLine());
            if (temp < 0){
                System.out.println("введите положительное число");
                continue;
            }
            numbers[count] = temp;
            count++;

        }
        System.out.println(maxDivider(numbers[0], numbers[1]));

    }

    public static int maxDivider(int a, int b){
        if (a == b){
            return a;
        }
        int max;
        int min;
        if (a > b){
            max = a;
            min = b;
        }
        else {
            max = b;
            min = a;
        }
        if ((max%min) == 0){
            return min;
        }
        for (int i = min; i > 1; i--)
        {
            if (((max%i) == 0) && ((min%i) == 0)){
                return i;
            }
        }
        return 1;
    }
}
