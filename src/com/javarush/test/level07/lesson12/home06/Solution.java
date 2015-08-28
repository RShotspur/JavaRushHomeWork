package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human grandPaDads = new Human("Виктор", true, 65, null, null);
        Human grandMaDads = new Human("Маруся", false, 59, null, null);
        Human myDad = new Human("Андрей", true, 48, grandPaDads, grandMaDads);
        Human grandPaMoms = new Human("Владимир", true, 63, null, null);
        Human grandMaMoms = new Human("Параска", false, 57, null, null);
        Human myMom = new Human("Лидия", false, 45, grandPaMoms, grandMaMoms);
        Human son1 = new Human("Артур", true, 20, myDad, myMom);
        Human son2 = new Human("Димон", true, 17, myDad, myMom);
        Human son3 = new Human("Вован", true, 9, myDad, myMom);

        System.out.println(grandPaDads.toString());
        System.out.println(grandPaMoms.toString());
        System.out.println(grandMaDads.toString());
        System.out.println(grandMaMoms.toString());
        System.out.println(myDad.toString());
        System.out.println(myMom.toString());
        System.out.println(son1.toString());
        System.out.println(son2.toString());
        System.out.println(son3.toString());



    }

    public static class Human
    {
        String name;
        Boolean sex;
        int age;
        Human father;
        Human mother;



        public Human(String name, Boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;

        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
