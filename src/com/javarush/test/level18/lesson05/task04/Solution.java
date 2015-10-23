package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileName2);

        byte[] buffer = new byte[fileInputStream.available()];
        if (fileInputStream.available() > 0)
        {
            fileInputStream.read(buffer);
        }

        for (int i = buffer.length; i > 0; i--)
        {
            fileOutputStream2.write(buffer[i-1]);
        }

        bufferedReader.close();
        fileInputStream.close();
        fileOutputStream2.close();

    }
}
