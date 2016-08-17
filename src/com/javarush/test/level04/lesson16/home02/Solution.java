package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String aa = reader.readLine();
        String bb = reader.readLine();
        String cc = reader.readLine();

        int a = Integer.parseInt(aa);
        int b = Integer.parseInt(bb);
        int c = Integer.parseInt(cc);

        int m1, m3;
        //вычисление максимума m3
        if (a > b && a >c){
            m3 = a;
        }
        else if (b > a && b > c){
            m3 = b;
        }
        else{
            m3 = c;
        }
        //вычисление минимума m1
        if (a < b && a < c){
            m1 = a;
        }
        else if (b < a && b < c){
            m1 = b;
        }
        else{
            m1 = c;
        }
        //вычисление среднего значания
        if (a < m3 && a > m1){
            System.out.println(a);
        }
        else if (b < m3 && b > m1){
            System.out.println(b);
        }
        else{
            System.out.println(c);
        }
    }
}
