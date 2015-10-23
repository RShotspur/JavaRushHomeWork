package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();


    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    private static boolean isWorking = true;

    public static void main(String[] args)
    {
        //start here - начни тут
        argController(args);
    }



    public static void argController (String[] arg)
    {
        if (Commands.EXIT.equals(arg[0]))
        {
            isWorking = false;
        }
        String[] argsToUse = new String[arg.length - 1];
        System.arraycopy(arg, 1, argsToUse, 0, arg.length - 1);

        if (Commands.CREATE.equals(arg[0]))
        {
            CreateAll(argsToUse);
        } else if (Commands.UPDATE.equals(arg[0]))
        {
            UpdateAll(argsToUse);
        } else if (Commands.DELETE.equals(arg[0]))
        {
            DeleteAll(argsToUse);
        } else if (Commands.INFO.equals(arg[0]))
        {
            Info(argsToUse);
        } else
        {
            System.out.println("pls try again...");
        }
    }

    public static void CreateAll(String[] arg)
    {
        String[] person = new String[3];
        for (int i = 0; i < arg.length; i += 3)
        {
            person[0] = arg[i];
            person[1] = arg[i+1];
            person[2] = arg[i+2];
            CreatePerson(getPerson(person));
        }
    }

    public static void UpdateAll(String[] arg)
    {
        String[] person = new String[3];
        int id;
        for (int i = 0; i < arg.length; i += 4)
        {
            id = Integer.parseInt(arg[i]);
            person[0] = arg[i+1];
            person[1] = arg[i+2];
            person[2] = arg[i+3];
            UpdatePerson(id, getPerson(person));
        }
    }

    public static synchronized void DeleteAll(String[] arg)
    {
        Person per;
        for (int i = 0; i < arg.length; i++)
        {
            per = allPeople.get(Integer.parseInt(arg[i]));
            per.setBirthDay(null);
        }
    }

    public static synchronized void Info(String[] arg)
    {
        for (int i = 0; i < arg.length; i++)
        {
            printInfo(allPeople.get(Integer.parseInt(arg[i])));
        }
    }

    public static void printInfo(Person person)
    {
        String sex = (person.getSex() == Sex.MALE) ? "м" : "ж";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.println(person.getName() + " " + sex + " " + simpleDateFormat.format(person.getBirthDay()));
    }

    public static Person getPerson(String[] person)
    {
        String name = person[0];
        String sex = person[1];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date bd = new Date();
        try
        {
            bd = simpleDateFormat.parse(person[2]);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return sex.equals("м") ? Person.createMale(name, bd) : Person.createFemale(name, bd);

    }

    public static synchronized void CreatePerson(Person person){
        allPeople.add(person);
        System.out.println(allPeople.size() - 1);
    }

    public static synchronized void UpdatePerson(int id, Person person){
        Person per = allPeople.get(id);
        per.setName(person.getName());
        per.setSex(person.getSex());
        per.setBirthDay(person.getBirthDay());
    }
}