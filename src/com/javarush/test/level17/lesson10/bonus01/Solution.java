package com.javarush.test.level17.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception{
        Person person = null;
        if (args[0].equals("-c"))
        {
            if (args[2].equals("м"))
                person = Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
            else if (args[2].equals("ж"))
                person = Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        } else if (args[0].equals("-u"))
        {
            allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(args[4]));
            if (args[3].equals("-м"))
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
            else if (args[3].equals("ж"))
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
        } else if (args[0].equals("-d"))
        {
            person = allPeople.get(Integer.parseInt(args[1]));
            person.setBirthDay(null);
        } else if ((args[0].equals("-i")))
        {
            person = allPeople.get(Integer.parseInt(args[1]));
            String name = person.getName();
            String sex;
            if (person.getSex() == Sex.MALE)
                sex = "м";
            else
                sex = "ж";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String date = simpleDateFormat.format(person.getBirthDay());
            System.out.println(name + " " + sex + " " + date);
        }
    }
}
//My code doesn't pass validation

//public class Solution {
//    public static List<Person> allPeople = new ArrayList<Person>();
//    static {
//        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
//        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
//    }
//    private static boolean isWorking = true;
//
//    public static void main(String[] args) throws IOException {
//        //start here - начни тут
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String temp;
//        while (isWorking){
//            temp = reader.readLine();
//            temp = "-c Миронов м 15/04/1990";
//            parseAndChoose(temp);
//        }
//    }
//
//    public static void parseAndChoose(String line) {
//        if (Commands.EXIT.equals(line.substring(0, 2))){
//            isWorking = false;
//        } else if (Commands.CREATE.equals(line.substring(0, 2))){
//            Create(line.substring(3));
//        } else if (Commands.UPDATE.equals(line.substring(0, 2))){
//            Update(line.substring(3));
//        } else if (Commands.DELETE.equals(line.substring(0, 2))){
//            Delete(Integer.parseInt(line.substring(3)));
//        } else if (Commands.INFO.equals(line.substring(0, 2))){
//            Info(Integer.parseInt(line.substring(3)));
//        } else {
//            System.out.println("pls try again...");
//        }
//    }
//
//    public static void Create(String line) {
//        allPeople.add(parseStringToPerson(line));
//    }
//
//    public static void Update(String line) {
//        String idString = line.substring(0, line.indexOf(" "));
//        int id = Integer.parseInt(idString);
//        line = line.substring(idString.length() + 1);
//        allPeople.set(id, parseStringToPerson(line));
//    }
//
//    public static void Delete(int id) {
//        Person per = allPeople.get(id);
//        per.setName(null);
//        per.setSex(null);
//        per.setBirthDay(null);
//        allPeople.set(id, per);
//    }
//
//    public static void Info (int id) {
//        printInfo(allPeople.get(id));
//    }
//
//    public static void printInfo(Person person){
//        String sex = person.getSex().equals("MALE")?"м":"ж";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//        System.out.println(person.getName() + " " + sex + " " + simpleDateFormat.format(person.getBirthDay()));
//    }
//
//    public static Person parseStringToPerson(String line) {
//        String name = line.substring(0, line.indexOf(" "));
//        line = line.substring(name.length()+1);
//        String sex = line.substring(0, 1);
//        String bdLine = line.substring(2);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date bd = new Date();
//        try
//        {
//            bd = simpleDateFormat.parse(bdLine);
//        }
//        catch (ParseException e)
//        {
//            e.printStackTrace();
//        }
//        return sex.equals("м")?Person.createMale(name, bd):Person.createFemale(name, bd);
//    }
//
//}
