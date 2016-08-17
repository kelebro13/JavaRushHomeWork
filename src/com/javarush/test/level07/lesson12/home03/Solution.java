package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] chisla = new int[20];
        int  maximum;
        int  minimum;

        for (int i = 0; i < chisla.length; i++)
        {
            chisla[i] = Integer.parseInt(reader.readLine());
        }
        maximum = chisla[0];
        minimum = chisla[0];

        for (int i = 0; i < chisla.length; i++)
        {
            if (chisla[i] > maximum)
            {
                maximum = chisla[i];
            }
            if (chisla[i] < minimum)
            {
                minimum = chisla[i];
            }
        }

        //напишите тут ваш код


        System.out.println(maximum);
        System.out.println(minimum);
    }
}
