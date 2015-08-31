package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private boolean sex;
        private ArrayList<Human> children;
        private String adress;
        private boolean isProgrammer;

        public Human(String name, int age, boolean sex, ArrayList<Human> children, String adress, boolean isProgrammer)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = children;
            this.adress = adress;
            this.isProgrammer = isProgrammer;
        }

        public Human(String name, int age, boolean sex, ArrayList<Human> children, String adress)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = children;
            this.adress = adress;
        }

        public Human(String name, int age, boolean sex, ArrayList<Human> children)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = children;
        }

        public Human(String name, int age, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public Human(String name)
        {
            this.name = name;
        }

        public Human(String name, boolean sex)
        {
            this.name = name;
            this.sex = sex;
        }

        public Human(int age, boolean sex)
        {
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, String adress, ArrayList<Human> children)
        {
            this.name = name;
            this.adress = adress;
            this.children = children;
        }

        public Human(String name, int age, boolean sex, ArrayList<Human> children, boolean isProgrammer)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = children;
            this.isProgrammer = isProgrammer;
        }
    }
}
