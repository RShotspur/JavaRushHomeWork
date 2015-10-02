package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //Add your code here
        try
        {
            FileInputStream readFile = new FileInputStream("ksjdnfkjsdn");
            int er = readFile.available();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            int[] array = new int[2];
            for (int i = 0; i < 4; i++)
            {
                array[i] = i;
            }

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //Add your code here
        try
        {
            FileInputStream readFile = new FileInputStream("ksjdnfkjsdn");
            int er = readFile.available();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            int[] array = new int[2];
            for (int i = 0; i < 4; i++)
            {
                array[i] = i;
            }

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //Add your code here
        try
        {
            FileInputStream readFile = new FileInputStream("ksjdnfkjsdn");
            int er = readFile.available();

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            int[] array = new int[2];
            for (int i = 0; i < 4; i++)
            {
                array[i] = i;
            }

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }


    }
}
