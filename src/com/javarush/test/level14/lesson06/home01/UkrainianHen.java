package com.javarush.test.level14.lesson06.home01;

/**
 * Created by ADI on 26.09.2015.
 */
public class UkrainianHen extends Hen{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 2;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
