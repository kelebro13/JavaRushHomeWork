package com.javarush.test.level19.lesson10.home04;

import com.sun.rowset.internal.WebRowSetXmlReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(br.readLine()));
        br.close();

        while(fr.ready()){
            String[] line = fr.readLine().split(" ");
            int count = 0;
            for(String s : line){
                if(words.contains(s)){
                    count++;
                }
            }
            if(count == 2){
                for(String s : line){
                    System.out.print(s + " ");
                }
            }
        }
        fr.close();

    }
}
