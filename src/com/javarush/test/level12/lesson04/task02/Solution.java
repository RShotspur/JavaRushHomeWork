package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        int x = 100;
        Integer y = 150;

        print(x);
        print(y);

    }

    //Напишите тут ваши методы
    public static void print(int x){
        System.out.println(x);
    }
    public static void print(Integer x){
        System.out.println(x);
    }
}
