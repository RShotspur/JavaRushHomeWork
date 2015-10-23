package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int temp = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream stream = new FileInputStream(reader.readLine());

        while (stream.available() > 0) {
            temp = stream.read();
            if (!map.containsKey(temp)) {
                map.put(temp, 0);
            }
            if(temp > max) {
                max = temp;
            }
        }

        reader.close();
        stream.close();

        for (int i = 0; i < max + 1; i++)
        {
            if (map.containsKey(i)) {
                System.out.println(i + " ");
            }

        }

    }
}
