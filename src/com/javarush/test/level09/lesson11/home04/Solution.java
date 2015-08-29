package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = reader.readLine();


        try
        {
            SimpleDateFormat date = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
            SimpleDateFormat inputDate = new SimpleDateFormat("MM/dd/yyyy");
            Date dateInput = inputDate.parse(inputString);
            System.out.println(date.format(dateInput).toUpperCase());
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
