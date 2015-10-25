package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());

        FileInputStream inputStream = new FileInputStream(file1);
        BufferedWriter outputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)));

        List<String> allLines = new ArrayList<String>();
        allLines.add("");

        final int space = (byte) ' ';
        int temp = 0;
        String tempString;
        int index = 0;

        while (inputStream.available() > 0){
            temp = inputStream.read();
            if (temp == space){
                index++;
                allLines.add("");
                continue;
            } else {
                tempString = allLines.get(index) + (char) temp;
                allLines.set(index, tempString);
            }
        }



        double[] doubles = new double[allLines.size()];

        for (int i = 0; i < doubles.length; i++)
        {
            doubles[i] = Double.parseDouble(allLines.get(i));
        }

        tempString = "";
        for (double x : doubles){
            tempString += Long.toString(Math.round(x)) + " ";
        }

        outputStream.write(tempString);

        reader.close();
        inputStream.close();
        outputStream.close();

    }
}
