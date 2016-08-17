package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
            File your_file_name = File.createTempFile("tmp", ".txt", new File("C:/Users/DNS/Desktop/Java"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("Timur");
            user.setLastName("Gumerov");
            user.setBirthDate(format.parse("06.05.1987"));
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();

            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<User>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            if(this.users != null){
                for(User user : this.users){
                    writer.println(user.getFirstName());
                    writer.println(user.getLastName());
                    writer.println(f.format(user.getBirthDate()));
                    writer.println(user.isMale());
                    writer.println(user.getCountry().getDisplayedName());
                }
            }
            writer.close();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            while(reader.ready()){
                     User u = new User();
                    u.setFirstName(reader.readLine());
                    u.setLastName(reader.readLine());
                    u.setBirthDate(f.parse(reader.readLine()));
                    u.setMale(Boolean.parseBoolean(reader.readLine()));
                    String country = reader.readLine();

                    if (country.equals("Ukraine")) {
                        u.setCountry(User.Country.UKRAINE);
                    } else if (country.equals("Russia")){
                        u.setCountry(User.Country.RUSSIA);
                    }else{
                        u.setCountry(User.Country.OTHER);
                    }

                    this.users.add(u);


                }
            reader.close();
            //implement this method - реализуйте этот метод
        }
    }
}
