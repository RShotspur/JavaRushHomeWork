package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException, ParseException
        {
            String line = scanner.nextLine();
            String[] data = line.split(" ");
            String firstName = data[1];
            String middleName = data[2];
            String lastName = data[0];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");

            Date bd = simpleDateFormat.parse(data[3] + data[4] + data[5]);
            Person person = new Person(firstName, middleName, lastName, bd);
            return person;
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();

        }
    }
}
