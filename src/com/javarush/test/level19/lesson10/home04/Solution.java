package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));

        List<String> list = new ArrayList<String>();
        while (fileReader.ready()) {
            list.add(fileReader.readLine());
        }

        for (String s : list) {
            String[] line = s.split(" ");
            List<String> lineList = new ArrayList<String>();
            Collections.addAll(lineList, line);
            int count = 0;
            for (String word : words) {
                if (lineList.contains(word))
                    count++;
            }
            if (count == 2)
                System.out.println(s);
        }

        reader.close();
        fileReader.close();

    }
}
