package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.util.*;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //2
        try
        {
            int[] i = {0, 1};
            for(int j = 0; j < i.length+1; j++){
                i[j] = 0;
            }

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //3
        try
        {
            FileInputStream file = new FileInputStream("d:/111.txt");
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //4
        try
        {
            String s = "privet";
            int q = Integer.parseInt(s);
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //5
        try
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(0,0);
            list.remove(3);
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //6
        try
        {
            Object ob[] = new String[2];
            ob[0] = new Character('1');

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //7        try
        try{
            int [] mass = new int[-5];
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //8
        try{
           int[] nullMas = new int[5];
            nullMas = null;
            int i = nullMas.length;
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //9
        try{
            String strika = "Ok";
            char c = strika.charAt(10);
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //10
        Object ch = new Character('*');

        try
        {
            System.out.println((Byte)ch);
        }
         catch (Exception e)
        {
            exceptions.add(e);
        }
        //Add your code here

    }
}
