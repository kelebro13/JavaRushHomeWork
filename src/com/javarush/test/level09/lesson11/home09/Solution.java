package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> mapCat = new HashMap<String, Cat>();
        mapCat.put("A", new Cat("A"));
        mapCat.put("B", new Cat("B"));
        mapCat.put("C", new Cat("C"));
        mapCat.put("D", new Cat("D"));
        mapCat.put("F", new Cat("F"));
        mapCat.put("E", new Cat("E"));
        mapCat.put("H", new Cat("H"));
        mapCat.put("J", new Cat("J"));
        mapCat.put("I", new Cat("I"));
        mapCat.put("W", new Cat("W"));

        return mapCat;//напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> convMapToSet = new HashSet<Cat>();
        for(Map.Entry<String, Cat> pair : map.entrySet()){
            Cat value = pair.getValue();
            convMapToSet.add(value);
        }
        return convMapToSet;//напишите тут ваш код
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
