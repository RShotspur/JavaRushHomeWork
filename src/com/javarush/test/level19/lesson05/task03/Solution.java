package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] splited = line.split(" ");
            Pattern pattern = Pattern.compile("[0-9]+");
            for (String s : splited) {
                Matcher matcher = pattern.matcher(s);
                if (matcher.matches()) {
                    fileWriter.write(s + " ");
                }
            }
        }

        reader.close();
        fileReader.close();
        fileWriter.close();

    }
}
