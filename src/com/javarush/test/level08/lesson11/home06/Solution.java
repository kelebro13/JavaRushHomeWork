package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human son1 = new Human("S1", true, 18);
        Human son2 = new Human("S2", true, 18);
        Human son3 = new Human("S3", true, 18);
        Human mam = new Human("M", true, 30, son1, son2, son3);
        Human dad = new Human("D", true, 30, son1, son2, son3);
        Human gmam1 = new Human("GM1", true, 60, mam);
        Human gdad1 = new Human("GD1", true, 60, mam);
        Human gmam2 = new Human("GM2", true, 60, dad);
        Human gdad2 = new Human("GD2", true, 60, dad);

        System.out.println(gdad2);
        System.out.println(gmam2);
        System.out.println(gdad1);
        System.out.println(gmam1);
        System.out.println(dad);
        System.out.println(mam);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(son3);//напишите тут ваш код
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            ArrayList<Human> list = new ArrayList<Human>();
            this.children = list;
        }
        public Human(String name, boolean sex, int age, Human a)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            ArrayList<Human> list = new ArrayList<Human>();
            list.add(a);
            this.children = list;
        }

        public Human(String name, boolean sex, int age, Human a, Human b, Human c)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            ArrayList<Human> list = new ArrayList<Human>();
            list.add(a);
            list.add(b);
            list.add(c);
            this.children = list;
        }//напишите тут ваш код


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
