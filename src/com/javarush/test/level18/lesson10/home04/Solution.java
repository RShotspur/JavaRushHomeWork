package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(bufferedReader.readLine());
        File file2 = new File(bufferedReader.readLine());
        FileInputStream inputStream1 = new FileInputStream(file1);
        FileInputStream inputStream2 = new FileInputStream(file2);

        byte[] buffer1 = new byte[inputStream1.available()];
        byte[] buffer2 = new byte[inputStream2.available()];

        while (inputStream1.available() > 0){
            int count = inputStream1.read(buffer1);
        }

        while (inputStream2.available() > 0){
            int count = inputStream2.read(buffer2);
        }

        byte[] result = new byte[buffer1.length + buffer2.length];

        System.arraycopy(buffer2, 0, result, 0, buffer2.length);
        System.arraycopy(buffer1, 0, result, buffer2.length, buffer1.length);

        bufferedReader.close();
        inputStream1.close();
        inputStream2.close();

        FileOutputStream fileOutputStream = new FileOutputStream(file1);

        fileOutputStream.write(result);

        fileOutputStream.close();


    }
}
