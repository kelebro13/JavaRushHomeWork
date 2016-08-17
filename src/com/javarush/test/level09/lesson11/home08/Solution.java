package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int []> list = new ArrayList<int[]>();
        int [] a = {5,5,5,5,5}, b = {2,2}, c = {4,4,4,4}, i = {1,2,3,4,5,6,7};
        int [] f = new int[0];
        list.add(0, a);
        list.add(1, b);
        list.add(2, c);
        list.add(3, i);
        list.add(4, f);

        return list;//напишите тут ваш код
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
