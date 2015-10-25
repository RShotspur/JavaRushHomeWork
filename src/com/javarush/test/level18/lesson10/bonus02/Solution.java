package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int maxId = lastMaxId(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        if (args[0].equals("-c")){
            writer.newLine();
            writer.write(stringBuilder(++maxId, args[1], args[2], args[3]));
        }

        reader.close();
        writer.close();
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
