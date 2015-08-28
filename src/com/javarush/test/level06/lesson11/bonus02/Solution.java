package com.javarush.test.level06.lesson11.bonus02;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: маму, папу, сына, дочь, бабушку(мамина мама) и дедушку(папин папа).
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandPaName = reader.readLine();
        Cat catGrandPa = new Cat(grandPaName, null, null);

        String grandMaName = reader.readLine();
        Cat catGrandMa = new Cat(grandMaName, null, null);

        String paName = reader.readLine();
        Cat catPa = new Cat(paName, null, catGrandPa);

        String maName = reader.readLine();
        Cat catMa = new Cat(maName, catGrandMa, null);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMa, catPa);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMa, catPa);

        System.out.println(catGrandPa);
        System.out.println(catGrandMa);
        System.out.println(catPa);
        System.out.println(catMa);
        System.out.println(catSon);
        System.out.print(catDaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat parentPa;
        private Cat parentMa;

        Cat(String name, Cat parentMa, Cat parentPa){
            this.name = name;
            this.parentPa = parentPa;
            this.parentMa = parentMa;

        }

        @Override
        public String toString()
        {
            if ((parentMa == null) && (parentPa == null))
                return "Cat name is " + name + ", no mother " + ", no father";
            else
            {
                if (parentMa == null)
                    return "Cat name is " + name + ", no mother " + ", father is " + parentPa.name;
                else if (parentPa == null)
                    return "Cat name is " + name + ", mother is " + parentMa.name + ", no father";
                else
                    return "Cat name is " + name + ", mother is " + parentMa.name + ", father is " + parentPa.name;
            }


        }
    }

}
