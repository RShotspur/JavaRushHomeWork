package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    String name = null;
    int mHeight;
    String mColor = null;

    public Dog(String name){
        this.name = name;
    }

    public Dog(String name, int mHeight){
        this.name = name;
        this.mHeight = mHeight;
    }

    public Dog(String name, int mHeight, String mColor){
        this.name = name;
        this.mHeight = mHeight;
        this.mColor = mColor;
    }
}
