package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        int m;
        int maximum = 0;
        if(n > 0){
            m = Integer.parseInt(sc.readLine());
            maximum = m;
            for(int i = 1; i < n; i++){
                m = Integer.parseInt(sc.readLine());
                if(m > maximum){
                    maximum = m;
                }

            }System.out.println(maximum);
        }else{
            System.out.println("Error: Введено отрицательное число");
        }




    }
}
