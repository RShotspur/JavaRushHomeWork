package com.javarush.test.level08.lesson08.task04;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        HashMap<String, Date> temp = new HashMap<String, Date>();
        temp = createMap();
        removeAllSummerPeople(temp);
        for (Map.Entry<String, Date> pair : temp.entrySet()){
            int dataTemp = pair.getValue().getMonth();
            //System.out.println(dataTemp);
        }


    }
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JULY 1 1980"));
        map.put("Сталлоне2", new Date("JUNE 2 1970"));
        map.put("Сталлоне3", new Date("AUGUST 3 1990"));
        map.put("Сталлоне4", new Date("JUNE 4 2000"));
        map.put("Сталлоне5", new Date("APRIL 5 2010"));
        map.put("Сталлоне6", new Date("JULY 6 1995"));
        map.put("Сталлоне7", new Date("JULY 7 1985"));
        map.put("Сталлоне8", new Date("AUGUST 8 1988"));
        map.put("Сталлоне9", new Date("NOVEMBER 9 1985"));
        map.put("Сталлоне10", new Date("JULY 10 1960"));

        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {

        for (Map.Entry<String, Date> pair : map.entrySet()){
            if ((4 < pair.getValue().getMonth()) && (pair.getValue().getMonth() < 8)){
                map.remove(pair.getKey());

            }
        }
        System.out.println(map);

    }


}
