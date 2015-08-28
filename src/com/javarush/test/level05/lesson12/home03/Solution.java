package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/



public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);
        Mouse muscleMouse = new Mouse("Muscle", 15, 2);
        Mouse pecosMouse = new Mouse("Pecos", 13, 3);
        Mouse nibblsMouse = new Mouse("Nibbls", 10, 1);
        Cat tomCat = new Cat("Tom", 5, 4);
        Cat tutsCat = new Cat("Tuts", 3, 2);
        Cat butchCat = new Cat("Butch", 6, 3);
        Dog spykeDog = new Dog("Spyke", 8, 20);
        Dog tajkDog = new Dog("Tajk", 1, 2);

    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Cat {
        String name;
        int age;
        int weigth;

        public Cat(String name, int age, int weigth){
            this.name = name;
            this.age = age;
            this.weigth = weigth;
        }
    }

    public static class Dog {
        String name;
        int age;
        int weigth;
        public Dog(String name, int age, int weigth){
            this.name = name;
            this.age = age;
            this.weigth = weigth;
        }
    }


}
