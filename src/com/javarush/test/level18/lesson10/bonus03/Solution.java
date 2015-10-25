package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int maxId = lastMaxId(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        if (args[0].equals("-c")){
            writer.newLine();
            writer.write(stringBuilder(++maxId, args[1], args[2], args[3]));
            writer.close();
        } else if(args[0].equals("-u")){
            stringUpdater(fileName, Integer.parseInt(args[1]), args[2], args[3], args[4]);
        } else if (args[0].equals("-d")) {
            writer.close();
            stringRemover(Integer.parseInt(args[1]), fileName);
        }

        reader.close();
    }


    public static String stringBuilder(int id, String productName, String price, String quantity) {
        String result;
        String resIdString = String.valueOf(id) + addSpaces(8 - String.valueOf(id).length());
        String resProductName;
        if (productName.length() > 30){
            resProductName = productName.substring(0, 30);
        } else {
            resProductName = productName + addSpaces(30 - productName.length());
        }
        String resPrice = price + addSpaces(8 - price.length());
        String resQuantity = quantity + addSpaces(4 - quantity.length());
        result = resIdString + resProductName + resPrice + resQuantity;

        return result;
    }

    public static void stringRemover(int id, String fileName) throws IOException
    {
        List<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()){
            list.add(reader.readLine());
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (String line : list){
            if (line.length() > 30){
                if (line.substring(0, 8).contains(" ")){
                    if (Integer.parseInt(line.substring(0, line.indexOf(" "))) == id) {
                        continue;
                    } else {
                        writer.newLine();
                        writer.write(line);
                    }
                } else {
                    if (Integer.parseInt(line.substring(0, 8)) == id) {
                        continue;
                    } else {
                        writer.newLine();
                        writer.write(line);
                    }
                }
            }
        }

        writer.close();

    }

    public static void stringUpdater(
            String fileName, int id, String productName, String price, String quantity) throws IOException
    {
        List<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()){
            list.add(reader.readLine());
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (String line : list){
            if (line.length() > 30){
                if (line.substring(0, 8).contains(" ")){
                    if (Integer.parseInt(line.substring(0, line.indexOf(" "))) == id) {
                        writer.newLine();
                        writer.write(stringBuilder(id, productName, price, quantity));
                    } else {
                        writer.newLine();
                        writer.write(line);
                    }
                } else {
                    if (Integer.parseInt(line.substring(0, 8)) == id) {
                        writer.newLine();
                        writer.write(stringBuilder(id, productName, price, quantity));
                    } else {
                        writer.newLine();
                        writer.write(line);
                    }
                }
            }
        }

        writer.close();
    }

    public static int lastMaxId (String fileName) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String str;
        int max = 0;
        while (reader.ready()){
            int temp;
            str = reader.readLine();
            if (str.length() > 40)
            {
                if (str.substring(0, 8).contains(" "))
                {
                    temp = Integer.parseInt(str.substring(0, str.indexOf(" ")));
                } else
                {
                    temp = Integer.parseInt(str.substring(0, 8));
                }
                if (temp > max)
                    max = temp;
            } else {
                continue;
            }
        }

        reader.close();

        return max;

    }

    public static String addSpaces(int count){
        if (count == 0){
            return "";
        }
        String result = " ";
        for (int i = 1; i < count; i++)
        {
            result += " ";
        }
        return result;
    }
}

