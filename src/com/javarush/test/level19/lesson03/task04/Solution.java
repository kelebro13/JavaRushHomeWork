package com.javarush.test.level19.lesson03.task04;

import java.io.*;
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

//    public static void main(String[] args) throws Exception{
//        Scanner scanner = new Scanner(new File("C:\\Users\\DNS\\Desktop\\Java\\a.txt"));
//        String s = scanner.nextLine();
//        String[] tmp = s.split(" ");
//        String date = String.format("%s %s %s", tmp[3], tmp[4], tmp[5]);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
//        Date birthDate = null;
//        try{
//            birthDate = simpleDateFormat.parse(date);
//        }catch(ParseException e){
//
//        }
//
//        Person person = new Person(tmp[1], tmp[2], tmp[0], birthDate);
//        System.out.println(person.toString());
//
//
//    }

    public static class PersonScannerAdapter implements PersonScanner {



        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String s = this.scanner.nextLine();
            String[] tmp = s.split(" ");
            String date = String.format("%s %s %s", tmp[3], tmp[4], tmp[5]);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            Date birthDate = null;
            try{
                birthDate = simpleDateFormat.parse(date);
            }catch(ParseException e){

            }

            Person person = new Person(tmp[1], tmp[2], tmp[0], birthDate);
            return person;
        }

        @Override
        public void close() throws IOException {
            this.scanner.close();
        }
    }
}
