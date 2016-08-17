package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: маму, папу, сына, дочь, бабушку(мамина мама) и дедушку(папин папа).
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String granddadName = reader.readLine();
        Cat catGranddad = new Cat(granddadName);

        String grandmamName = reader.readLine();
        Cat catGrandmam = new Cat(grandmamName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, catGranddad, null);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, null, catGrandmam);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catFather, catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catFather, catMother);

        System.out.println(catGranddad);
        System.out.println(catGrandmam);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat parentDad;
        private Cat parentMam;


        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name,  Cat parentDad, Cat parentMam)
        {
            this.name = name;
            this.parentDad = parentDad;
            this.parentMam = parentMam;

        }

        @Override
        public String toString()
        {
            if(parentDad == null && parentMam == null)
                return "Cat name is " + name + ", no mother" +", no father";
            if(parentMam == null)
                return "Cat name is " + name + ", no mother" + ", father is " + parentDad.name;
            if(parentDad == null)
                return "Cat name is " + name + ", mother is " + parentMam.name + ", no father";
            else
                return "Cat name is " + name + ", mother is " + parentMam.name + ", father is " + parentDad.name;
        }
    }

}
