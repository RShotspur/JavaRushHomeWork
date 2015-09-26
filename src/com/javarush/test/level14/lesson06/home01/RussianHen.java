package com.javarush.test.level14.lesson06.home01;

/**
 * Created by ADI on 26.09.2015.
 */

public class RussianHen extends Hen{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 1;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}

