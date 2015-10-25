package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        File file = new File(args[0]);
        FileInputStream inputStream = new FileInputStream(file);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        int temp;

        while (inputStream.available() > 0) {
            temp = inputStream.read();
            if (temp > max)
                max = temp;

            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }

        for (int i = 0; i < max + 1; i++)
        {
            if (map.containsKey(i)) {
                System.out.println((char) i + " " + map.get(i));
            }
        }

        inputStream.close();

    }
}
