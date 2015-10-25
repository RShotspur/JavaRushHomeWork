package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);
        byte[] buffer = new byte[inputStream.available()];
        int count = inputStream.read(buffer);

        if (args[0].equals("-e")){

            outputStream.write(enCoding(buffer));


        } else if (args[0].equals("-d")) {

            outputStream.write(deCoding(buffer));

        }

        inputStream.close();
        outputStream.close();


    }

    public static byte[] enCoding (byte[] buffer) {
        byte[] result = new byte[buffer.length];
        for (int i = 0; i < buffer.length; i++)
        {
            result[i] = (byte) ((byte) ' ' + (buffer[i]));
        }
        return result;
    }
    public static byte[] deCoding (byte[] buffer) {
        byte[] result = new byte[buffer.length];
        for (int i = 0; i < buffer.length; i++)
        {
            result[i] = (byte) ((buffer[i]) - (byte) ' ' );
        }
        return result;
    }



}
