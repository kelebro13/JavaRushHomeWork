package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.util.ArrayList;
import java.util.HashMap;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private String address;
        private ArrayList<Human> parents;
        private ArrayList<Human> children;

        public Human(){
          this.name = "John Doe";
        }

        public Human(String name){
            this.name = name;
        }

        public Human(String name, boolean sex){
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, String address)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.address = address;
        }

        public Human(String name, boolean sex, String address) {
            this.name = name;
            this.sex = sex;
            this.address = address;
        }

        public Human(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public Human(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Human(String name, boolean sex, int age, String address, Human dad, Human mam)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.address = address;
            this.parents.add(dad);
            this.parents.add(mam);
        }

        public Human(String name, boolean sex, int age, String address, Human dad, Human mam, Human child1, Human child2)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.address = address;
            this.parents.add(dad);
            this.parents.add(mam);
            this.children.add(child1);
            this.children.add(child2);
        }

        //напишите тут ваши переменные и конструкторы
    }
}
