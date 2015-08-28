package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;


/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashSet<Integer> set = createSet();
        System.out.println(removeAllNumbersMoreThan10(set));
    }
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> list = new HashSet<Integer>();
        list.add(312);
        list.add(21);
        list.add(23123);
        list.add(2);
        list.add(5);
        list.add(3213);
        list.add(1);
        list.add(232);
        list.add(9);
        list.add(231);

        list.add(3412);
        list.add(521);
        list.add(3123);
        list.add(23);
        list.add(4);
        list.add(32413);
        list.add(6);
        list.add(2372);
        list.add(90);
        list.add(2313);

        return list;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        HashSet<Integer> temp = new HashSet<Integer>();
        for (Integer i : set){
            if (i<11){
                temp.add(i);
            }
        }
        return temp;
    }
}
