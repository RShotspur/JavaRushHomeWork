package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
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

        for (String name : names) {
            System.out.println(name + " " + salaryMap.get(name));
        }

        fileReader.close();

    }
}
