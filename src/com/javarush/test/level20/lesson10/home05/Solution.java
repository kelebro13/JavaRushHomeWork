package com.javarush.test.level20.lesson10.home05;


import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

//    public static void main(String[] args) throws Exception{
//        File file = File.createTempFile("tmp", ".txt", new File("C:\\Users\\DNS\\Desktop\\Java"));
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//        Person p = new Person("Tim", "Gum", "Rus", Sex.MALE);
//        oos.writeObject(p);
//        oos.close();
//
//        p = (Person)ois.readObject();
//        ois.close();
//
//        System.out.println("the end");
//    }

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }
}
