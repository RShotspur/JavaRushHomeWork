package com.javarush.test.level10.lesson11.home09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Одинаковые слова в списке
Ввести с клавиатуры в список 20 слов. Нужно подсчитать количество одинаковых слов в списке.
Результат нужно представить в виде словаря Map<String, Integer>, где первый параметр – уникальная строка,
а второй – число, сколько раз данная строка встречалась в списке.
Вывести содержимое словаря на экран.
В тестах регистр (большая/маленькая буква) не влияет на результат.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++)
        {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list)
    {
        HashMap<String, Integer> result = new HashMap<String, Integer>();


        //напишите тут ваш код
        //ущербы, это они завалидировали как правильное решение, я что-то в этой жизни не понимаю
        for (String word : list){
            if (result.containsKey(word)){
                result.put(word, result.get(word) + 1);
            }
            else {
                result.put(word, 1);
            }
        }


        //полностью рабочий код, не прошедший валидации на сервере, не понравилось ему это (

//        int count;
//        String tempStringLoverCase;
//        String tempStringLoverCase2;
//        ArrayList<String> listTemp = list;
//        for (int i = 0; i < list.size(); i++)
//        {
//            count = 0;
//            tempStringLoverCase = list.get(i).toLowerCase();
//            for (int j = 0; j < listTemp.size(); j++)
//            {
//                tempStringLoverCase2 = listTemp.get(j).toLowerCase();
//                if (tempStringLoverCase.equals(tempStringLoverCase2)){
//                    System.out.println(tempStringLoverCase + " equals to " + tempStringLoverCase2);
//                    count++;
//                    System.out.println(count);
//                }
//            }
//            if (count > 1){
//                result.put(tempStringLoverCase, count);
//            }
//
//
//        }


        return result;
    }


}
