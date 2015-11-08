package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    //todo
    public static void main(String[] args)
    {
        Date start = new Date();
        for (int i : getNumbers(100000000))
            System.out.println(i);
        Date end = new Date();
        long time = end.getTime() - start.getTime();
        System.out.println("time: " + time);
    }

    public static int[] getNumbers(int N) {
        int[] result = null;
        List<Integer> listNumbers = new ArrayList<Integer>();
        int length;
        String n;
        long sum = 0;
        char[] numbers;
        for (int i = 1; i < N; i++) {
            n = String.valueOf(i);
            length = n.length();
            numbers = n.toCharArray();
            for(char c : numbers){
                sum += pow((short)Character.getNumericValue(c), (short)length);
            }
            if (sum == i)
                listNumbers.add(i);
            sum = 0;
        }
        result = new int[listNumbers.size()];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = listNumbers.get(i);
        }
        return result;
    }

    public static long pow(short a, short n) {
        if (n == 0) return 1;
        if (n % 2 == 0) {
            long ans = pow(a, (short)(n / 2));
            return ans * ans;
        } else {
            return a * pow(a, (short)(n - 1));
        }
    }



}
