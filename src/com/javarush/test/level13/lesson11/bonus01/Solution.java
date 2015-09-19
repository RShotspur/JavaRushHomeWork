package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    //MY OWN, WORKING!!!! but for some reason not correct

//    public static void main(String[] args) throws IOException
//    {
//        // напишите тут ваш код
//        // Read file Name, check for FileNotFoundException
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        FileInputStream fileInputStream;
//        while (true)
//        {
//            try
//            {
//                fileInputStream = new FileInputStream(reader.readLine());
//                break;
//            }
//            catch (FileNotFoundException e)
//            {
//                System.out.println("Файл не существует.");
//
//            }
//        }
//        //Create char array
//        ArrayList<Character> listChars = new ArrayList<Character>();
//        while (fileInputStream.available() > 0)
//        {
////            System.out.println(fileInputStream.read());
//            listChars.add((char)fileInputStream.read());
//        }
//        int count = 1;
//
//        for (Character character : listChars){
//            if (character.equals((char)13)){
//                count++;
//            }
//        }
//
//        String[] arrayString = new String[count];
//        ArrayList<Integer> listInt = new ArrayList<Integer>();
//        int temp = 0;
//
//        for (Character character : listChars){
//            if ((character.equals((char)13)) || (character.equals((char)10))){
//                if(character.equals((char)10)){
//                    continue;
//                }
//                if ((Integer.parseInt(arrayString[temp])%2) == 0){
//                    listInt.add(Integer.parseInt(arrayString[temp]));
//
//                }
//                temp++;
//                continue;
//            }
//            if (arrayString[temp] == null){
//                arrayString[temp] = character.toString();
//            } else {
//                arrayString[temp] = arrayString[temp] + character.toString();
//            }
//        }
//        //For last number
//        if ((Integer.parseInt(arrayString[temp])%2) == 0){
//            listInt.add(Integer.parseInt(arrayString[temp]));
//
//        }
//
//
//        for (int j = 0; j < listInt.size(); j++)
//        {
//            for (int k = j; k < listInt.size(); k++)
//            {
//                if (listInt.get(j) > listInt.get(k)){
//                    temp = listInt.get(j);
//                    listInt.set(j, listInt.get(k));
//                    listInt.set(k, temp);
//                }
//
//            }
//        }
//
//        for (Integer i : listInt){
//            System.out.println(i);
//        }
//
//        reader.close();
//        fileInputStream.close();
//
//
//    }
    public static void main(String[] args) throws IOException
    {
        //открываем поток для чтения имени файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close(); //закрываем поток

        //Создаем лист, в котором будем хранить данные
        ArrayList<Integer> list = new ArrayList<Integer>();

        //Открываем поток чтения из файла
        BufferedReader inputStream = new BufferedReader(new FileReader(fileName));

        while (inputStream.ready()) //пока данные читаются
        {
            int i = Integer.parseInt(inputStream.readLine());
            if (i%2==0) list.add(i);
        }

        Collections.sort(list); //сортируем

        for (int i : list) System.out.println(i);

    }
}
