package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/


import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Human human1 = new Human("Kate1", false, 10, new ArrayList<Human>());
        Human human2 = new Human("Kate2", false, 11, new ArrayList<Human>());
        Human human3 = new Human("Kate3", false, 12, new ArrayList<Human>());
        Human mother = new Human("Kate", false, 42, new ArrayList<Human>(Arrays.asList(human1, human2, human3)));
        Human father = new Human("Dad", true, 45, new ArrayList<Human>(Arrays.asList(human1, human2, human3)));
        Human grandMa1 = new Human("gMa1", false, 62, new ArrayList<Human>(Arrays.asList(mother)));
        Human grandMa2 = new Human("gMa2", false, 63, new ArrayList<Human>(Arrays.asList(father)));
        Human grandPa1 = new Human("gPa1", true, 65, new ArrayList<Human>(Arrays.asList(mother)));
        Human grandPa2 = new Human("gPa2", true, 66, new ArrayList<Human>(Arrays.asList(father)));

        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(grandMa1);
        System.out.println(grandMa2);
        System.out.println(grandPa1);
        System.out.println(grandPa2);

    }

    public static class Human
    {
        //Написать тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (!(this.children.isEmpty())){
                int childCount = this.children.size();
                if (childCount > 0)
                {
                    text += ", дети: "+this.children.get(0).name;

                    for (int i = 1; i < childCount; i++)
                    {
                        Human child = this.children.get(i);
                        text += ", "+child.name;
                    }
                }
            }

            return text;
        }
        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }
    }

}
