package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream fileInputStream = new FileInputStream(file2);
        FileInputStream fileInputStream3 = new FileInputStream(file3);
        FileOutputStream fileOutputStream = new FileOutputStream(file1);

        byte[] buffer1 = new byte[fileInputStream.available()];
        byte[] buffer3 = new byte[fileInputStream3.available()];
        int count1 = 0;
        int count3 = 0;

        while (fileInputStream.available() > 0) {
            count1 = fileInputStream.read(buffer1);
        }
        while (fileInputStream3.available() > 0) {
            count3 = fileInputStream3.read(buffer3);
        }

        fileOutputStream.write(buffer1, 0, count1);
        fileOutputStream.write(buffer3, 0, count3);

        reader.close();
        fileInputStream.close();
        fileInputStream3.close();
        fileOutputStream.close();

    }
}
