package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        sortInteger(array);
        sortString(array);
    }
//        ArrayList <Integer> integ = new ArrayList<Integer>();
//        ArrayList <String> str = new ArrayList<String>();
//        for(int i = 0; i < array.length; i++){
//            if(isNumber(array[i])){
//                integ.add(Integer.parseInt(array[i]));//напишите тут ваш код
//            }else{
//                str.add(array[i]);
//            }
//        }
//
//        for(int i = integ.size()-1; i > 0; i--){
//            for(int j = integ.size()-1; j > 0; j--){
//                if(integ.get(j) > integ.get(j-1)){
//                    int temp = integ.get(j-1);
//                    integ.set(j-1, integ.get(j));
//                    integ.set(j, temp);
//                }
//            }
//        }
//
//        for(int i = 0; i < str.size(); i++){
//            for(int j = 0; j < str.size()-1; j++){
//                if(isGreaterThen(str.get(j), str.get(j+1))){
//                    String temp = str.get(j+1);
//                    str.set(j+1, str.get(j));
//                    str.set(j, temp);
//                }
//            }
//        }
//
//        for(int i = 0, j = 0, k = 0; i < array.length; i++){
//            if(isNumber(array[i]))
//            {
//                array[i] = "" + integ.get(j);
//                j++;
//            }else{
//                array[i] = str.get(k);
//                k++;
//            }
//            }
//        }

    public static void sortInteger(String[] array){
        ArrayList <Integer> integ = new ArrayList<Integer>();
        for(int i = 0; i < array.length; i++){
            if(isNumber(array[i])){
                integ.add(Integer.parseInt(array[i]));//напишите тут ваш код
            }
        }

        for(int i = integ.size()-1; i > 0; i--){
            for(int j = integ.size()-1; j > 0; j--){
                if(integ.get(j) > integ.get(j-1)){
                    int temp = integ.get(j-1);
                    integ.set(j-1, integ.get(j));
                    integ.set(j, temp);
                }
            }
        }

        for(int i = 0, j = 0; i < array.length; i++){
            if(isNumber(array[i]))
            {
                array[i] = "" + integ.get(j);
                j++;
            }
        }
    }

    public static void sortString(String[] array){
        ArrayList <String> str = new ArrayList<String>();
        for(int i = 0; i < array.length; i++){
            if(!isNumber(array[i])){
                str.add(array[i]);
            }
        }

        for(int i = 0; i < str.size(); i++){
            for(int j = 0; j < str.size()-1; j++){
                if(isGreaterThen(str.get(j), str.get(j+1))){
                    String temp = str.get(j+1);
                    str.set(j+1, str.get(j));
                    str.set(j, temp);
                }
            }
        }
        for(int i = 0, k = 0; i < array.length; i++){
            if(!isNumber(array[i]))
            {
                array[i] = str.get(k);
                k++;
            }
        }
    }








    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
