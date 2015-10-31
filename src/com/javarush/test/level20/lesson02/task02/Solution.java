package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);


            // LOAD for two javaRush does not work, but there is a solution :)


            JavaRush javaRush = new JavaRush();
            JavaRush javaRush2 = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User());
            javaRush.users.get(0).setFirstName("ASDFG");
            javaRush.users.get(0).setLastName("QWERT");
            javaRush.users.get(0).setBirthDate(new Date());
            javaRush.users.get(0).setMale(true);
            javaRush.users.get(0).setCountry(User.Country.UKRAINE);
            javaRush.users.add(new User());
            javaRush.users.get(1).setFirstName("ASDFG1");
            javaRush.users.get(1).setLastName("QWERT1");
            javaRush.users.get(1).setBirthDate(new Date());
            javaRush.users.get(1).setMale(false);
            javaRush.users.get(1).setCountry(User.Country.OTHER);
            javaRush.save(outputStream);
 //           outputStream.flush();
            javaRush2.users.add(new User());
            javaRush2.users.get(0).setFirstName("ASDFG2");
            javaRush2.users.get(0).setLastName("QWERT2");
            javaRush2.users.get(0).setBirthDate(new Date());
            javaRush2.users.get(0).setMale(true);
            javaRush2.users.get(0).setCountry(User.Country.RUSSIA);
            javaRush2.users.add(new User());
            javaRush2.users.get(1).setFirstName("ASDFG3");
            javaRush2.users.get(1).setLastName("QWERT3");
            javaRush2.users.get(1).setBirthDate(new Date());
            javaRush2.users.get(1).setMale(false);
            javaRush2.users.get(1).setCountry(User.Country.OTHER);
            javaRush2.save(outputStream);
//            outputStream.flush();

//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
//            loadedObject.load(reader);
            JavaRush loadedObject2 = new JavaRush();
            loadedObject2.load(inputStream);
//            loadedObject2.load(reader);
            for (User user : loadedObject.users)
                System.out.println(user);
            for (User user : loadedObject2.users)
                System.out.println(user);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            String isUsersAvailable = users.size() != 0 ? "Y" : "N";
            printWriter.println(isUsersAvailable);
            if (users.size() != 0)
            {
                printWriter.println(users.size());
                for (User user : users)
                {

                    String isFirstNameAvailable = user.getFirstName().isEmpty() ? "no" : "yes";
                    printWriter.println(isFirstNameAvailable);
                    if (!user.getFirstName().isEmpty())
                        printWriter.println(user.getFirstName());

                    String isLastNameAvailable = user.getLastName().isEmpty() ? "no" : "yes";
                    printWriter.println(isLastNameAvailable);
                    if (!user.getLastName().isEmpty())
                        printWriter.println(user.getLastName());

                    String isBdAvailable = user.getBirthDate() == null ? "no" : "yes";
                    printWriter.println(isBdAvailable);
                    if (user.getBirthDate() != null)
                        printWriter.println(user.getBirthDate().getTime());

                    printWriter.println(user.isMale());

                    String isCountryAvailable = user.getCountry() == null ? "no" : "yes";
                    printWriter.println(isCountryAvailable);
                    if (user.getCountry() != null)
                        printWriter.println(user.getCountry());
                }
            }

            printWriter.flush();

        }

        public void load(InputStream inputStream) throws Exception {

            // that's how it could work with some number of javaRush objects
//        public void load(BufferedReader reader) throws Exception {
//            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (reader.readLine().equals("Y")){
                int size = Integer.parseInt(reader.readLine());
                for (int i = 0; i < size; i++)
                {
                    User user = new User();
                    if (reader.readLine().equals("yes"))
                        user.setFirstName(reader.readLine());
                    if (reader.readLine().equals("yes"))
                        user.setLastName(reader.readLine());
                    if (reader.readLine().equals("yes")) {
                        Date date = new Date();
                        date.setTime(Long.parseLong(reader.readLine()));
                        user.setBirthDate(date);
                    }
                    user.setMale(Boolean.parseBoolean(reader.readLine()));
                    if (reader.readLine().equals("yes"))
                        user.setCountry(User.Country.valueOf(reader.readLine()));

                    users.add(user);

                }
            }


        }
    }
}
