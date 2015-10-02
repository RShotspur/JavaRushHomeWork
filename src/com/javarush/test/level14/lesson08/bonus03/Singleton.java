package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by ADI on 02.10.2015.
 */
public class Singleton
{
    private final static Singleton instance = new Singleton();
    private Singleton()
    {
    }

    public static Singleton getInstance(){

        return instance;
    }
}
