package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        ArrayList<String> listData = new ArrayList<String>();
        Map<String, Double> salaryMap = new HashMap<String, Double>();

        while (fileReader.ready()){
            listData.add(fileReader.readLine());
        }

        for (String s : listData) {
            String[] pair = s.split(" ");
            if (salaryMap.containsKey(pair[0])){
                salaryMap.put(pair[0], salaryMap.get(pair[0]) + Double.parseDouble(pair[1]));
            } else {
                salaryMap.put(pair[0], Double.parseDouble(pair[1]));
            }
        }

        String[] names = new String[salaryMap.size()];
        int count = 0;
        for (Map.Entry<String, Double> pair : salaryMap.entrySet()){
            names[count++] = pair.getKey();
        }

        Arrays.sort(names);

        Collection<Double> salaries = salaryMap.values();
        double max = 0;

        for (Double d : salaries){
            if (d > max)
                max = d;
        }

        for (String name : names) {
            if (salaryMap.get(name) == max)
                System.out.println(name);
        }

        fileReader.close();
    }
}
