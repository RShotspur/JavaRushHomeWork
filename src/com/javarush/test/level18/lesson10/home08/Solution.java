package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        while (!fileName.equals("exit")){
            ReadThread thread = new ReadThread(fileName);
            thread.start();
            fileName = reader.readLine();
        }

        reader.close();

    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run()
        {
            try
            {
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                FileInputStream inputStream = new FileInputStream(fileName);
                int temp;
                while (inputStream.available() > 0) {
                    temp = inputStream.read();
                    if (map.containsKey(temp)) {
                        map.put(temp, map.get(temp) + 1);
                    } else {
                        map.put(temp, 1);
                    }
                }
                temp = 0;
                Collection<Integer> values = map.values();
                for (int x : values){
                    if (x > temp)
                        temp = x;
                }
                for (Map.Entry<Integer, Integer> pair : map.entrySet()){
                    if (pair.getValue() == temp){
                        addToResultMap(fileName, pair.getKey());
                    }
                }
                inputStream.close();

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void addToResultMap (String fileName, int byteInt) {
        resultMap.put(fileName, byteInt);
    }
}
