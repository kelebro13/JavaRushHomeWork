package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        String[] parts = s.split(" ");


            for (int i = 0; i < parts.length; i++)
            {
                if(!parts[i].isEmpty())
                {
                    String sub1 = parts[i].substring(0, 1);
                    String sub2 = parts[i].substring(1);
                    sub1 = sub1.toUpperCase();

                    String sub = sub1 + sub2;
                    parts[i] = sub + " ";

                }

            }
        String c = "";
        for(int i = 0; i < parts.length; i++)
        {
            c = c + parts[i];

            if(parts[i].isEmpty())
            {
                c = c + " ";
            }
        }

        System.out.println(c);






    }
//        for(int i = 0; i < parts.length; i++)
//        {
//            System.out.println(parts[i]);
//        }

    }



