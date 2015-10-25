package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        int count = 0;
        int x;

        FileInputStream fileInputStream = new FileInputStream(fileName);

        while (fileInputStream.available() > 0){
            x = fileInputStream.read();
            if ((x >= 65) && (x <= 90) || ((x >= 97) && (x <= 122))){
                count++;
            }
        }

        System.out.println(count);

        fileInputStream.close();
    }
}
