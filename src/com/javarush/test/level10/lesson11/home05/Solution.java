package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //алфавит с количеством букв
        ArrayList<Integer> countAlpha = new ArrayList<Integer>();
        for(int i = 0; i < 33; i++){
            countAlpha.add(i, 0);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
                String s = reader.readLine();
                list.add(s.toLowerCase());

        }

        //подсчет букв
        for(int i = 0; i < list.size(); i++){
            char [] stroka = list.get(i).toCharArray();
            for(int k = 0; k < alphabet.size(); k++){
                int chet = 0;
                for(int j = 0; j < stroka.length; j++){
                    if(alphabet.get(k) == stroka[j]){
                        chet++;
                    }
                }
                countAlpha.set(k,(countAlpha.get(k) + chet));
            }


        }

        //print count alpha

        for(int i = 0; i < alphabet.size(); i++){
            System.out.println(alphabet.get(i) + " " + countAlpha.get(i));
        }


    }

}
