package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(fileName));
        String text = "";
        while(reader.ready()){
            text = reader.readLine();
        }
        reader.close();

        String[] tmp = text.split("[\\p{Punct}[\\n]]");

        int count = 0;
        for(String s : tmp){
            if(s.equals("world")){
                count++;
            }
        }

        System.out.println(count);

    }
}
