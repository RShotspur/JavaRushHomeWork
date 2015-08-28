package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;



/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, String> flName = createMap();
        String name = "Сергей";
        String familiya = "Миляев";
        System.out.println(flName);
        System.out.println("Совпадений по имени " + name + " - " + getCountTheSameFirstName(flName, name));
        System.out.println("Совпадений по фамилии " + familiya + " - " + getCountTheSameLastName(flName, familiya));
    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> flName = new HashMap<String, String>();
        flName.put("Романов", "Роман");
        flName.put("Сергеев", "Сергей");
        flName.put("Романов2", "Сергей");
        flName.put("Сидоренко", "Петр");
        flName.put("Вылегжанин", "Алексей");
        flName.put("Вакуленчик", "Алексей");
        flName.put("Миляев", "Сергей");
        flName.put("Миляев2", "Лиза");
        flName.put("Вакуленчик2", "Оксана");
        flName.put("Романов3", "Петр");

        return flName;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()){
            if (pair.getValue().contains(name)) count++;

        }

        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()){
            if (pair.getKey().equals(familiya)) count++;

        }

        return count;

    }
}
