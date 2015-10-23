package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int temp = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream stream = new FileInputStream(reader.readLine());

        while (stream.available() > 0) {
            temp = stream.read();
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 0);
            }
        }

        reader.close();
        stream.close();

        Collection<Integer> list = map.values();

        for (int x : list) {
            if (x > temp){
                temp = x;
            }
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (pair.getValue() == temp) {
                System.out.println(pair.getKey() + " ");
            }
        }
    }
}
