package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        String chislo1 = reader.readLine();
        String chislo2 = reader.readLine();
        String chislo3 = reader.readLine();
        String chislo4 = reader.readLine();
        String chislo5 = reader.readLine();

        int[] ch = new int[5];

       ch[0] = Integer.parseInt(chislo1);
        ch[1] = Integer.parseInt(chislo2);
        ch[2] = Integer.parseInt(chislo3);
        ch[3] = Integer.parseInt(chislo4);
        ch[4] = Integer.parseInt(chislo5);

        for(int i = 0; i < ch.length - 1; i++){
            for(int j = 0; j < ch.length - i - 1; j++){
                if(ch[j] > ch[j + 1]){
                    int temp = ch[j + 1];
                    ch[j + 1] = ch[j];
                    ch[j] = temp;
                }
            }

        }

        for (int i = 0; i < ch.length; i++)
        {
            System.out.println(ch[i]);
        }


        //напишите тут ваш код
    }
}
