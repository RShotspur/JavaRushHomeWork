package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String name = null;
    private int mWeigth;
    private int age;
    private String mColor = null;
    private String adress = null;

    public Cat(String name){
        this.name = name;
        this.mWeigth = 2;
        this.mColor = "grey";
    }

    public Cat(String name, int mWeigth, int age){
        this.name = name;
        this.mWeigth = mWeigth;
        this.age = age;
        this.mColor = "grey";
    }

    public Cat(String name, int age){
        this.name = name;
        this.mWeigth = 2;
        this.age = age;
        this.mColor = "grey";
    }

    public Cat(int mWeigth, String mColor){
        this.mWeigth = mWeigth;
        this.mColor = mColor;
    }

    public Cat(int mWeigth, String mColor, String adress){
        this.mWeigth = mWeigth;
        this.mColor = mColor;
        this.adress = adress;
    }

}
