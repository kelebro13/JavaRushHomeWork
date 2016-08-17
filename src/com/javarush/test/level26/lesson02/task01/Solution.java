package com.javarush.test.level26.lesson02.task01;


import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        if(array.length == 0){
            return new Integer[0];
        }
        Arrays.sort(array);
        int len = array.length;
        int median = 0;
        if(len % 2 == 0){
            median =(array[len / 2] + array[(len / 2) - 1])  / 2;
        }else{
            median = array[len / 2];
        }
        final int m = median;
        Comparator<Integer> tmp = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                int x = Math.abs(m - o1);
                int y = Math.abs(m - o2);
                if(x == y){
                    return o1 - o2;
                }else
                {
                    return x - y;
                }
            }
        };
        Arrays.sort(array, tmp);
        //implement logic here
        return array;
    }
}
