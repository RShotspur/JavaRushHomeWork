package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        int count = 0;
        String s;
        Pattern p = Pattern.compile("\\bworld\\b", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);

        while (fileReader.ready())
        {
            s = fileReader.readLine();
            Matcher m = p.matcher(s);
            while (m.find())
                count++;
        }

        System.out.println(count);

        reader.close();
        fileReader.close();

    }
}
