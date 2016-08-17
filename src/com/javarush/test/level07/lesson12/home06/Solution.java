package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human granddad = new Human("Ded1", true, 60);
        Human granddad2 = new Human("Ded2", true,61);
        Human grandmam = new Human("Babka1", false,59);
        Human grandmam2 = new Human("Babka2", false, 60);
        Human dad = new Human("Dad", true, 40, granddad, grandmam);
        Human mam = new Human("Mam", false, 38, granddad2, grandmam2);
        Human son = new Human("Son1", true, 20, dad, mam);
        Human son2 = new Human("Son2", true, 18, dad, mam);
        Human daughter = new Human("Doch", false, 16, dad, mam);

        System.out.println(granddad.toString());
        System.out.println(granddad2.toString());
        System.out.println(grandmam.toString());
        System.out.println(grandmam2.toString());
        System.out.println(dad.toString());
        System.out.println(mam.toString());
        System.out.println(son.toString());
        System.out.println(son2.toString());
        System.out.println(daughter.toString());//напишите тут ваш код
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }//напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
