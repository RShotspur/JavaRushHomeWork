package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static String fileName;
    public static void main(String[] args) throws IOException
    {
        Map<Integer, byte[]> mapFiles = new HashMap<Integer, byte[]>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        String temp = reader.readLine();
        fileName = temp.substring(0, temp.lastIndexOf("."));

        while (!temp.equals("end")){
            FileInputStream inputStream = new FileInputStream(temp);
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            int num = Integer.parseInt(temp.substring(fileName.length() + 5));
            mapFiles.put(num, buffer);
            if (max < num)
                max = num;
            temp = reader.readLine();
            inputStream.close();
        }
        File file = new File(fileName);
        FileOutputStream outputStream = new FileOutputStream(file);
        for (int i = 1; i < max + 1; i++)
        {
            outputStream.write(mapFiles.get(i));
        }

        outputStream.close();
        reader.close();


    }
}
