package com.javarush.test.level22.lesson09.task01;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        rd = new BufferedReader(new FileReader(fileName));
        List<String> list = new LinkedList<>();
        while(rd.ready()){
            String [] tmp = rd.readLine().split(" ");
            for(int i = 0; i < tmp.length; i++){
                list.add(tmp[i]);
            }
        }
        rd.close();
        while (list.size() > 0){
            String s = list.get(0);
            StringBuilder tmp = new StringBuilder(s).reverse();
            String ss = new String(tmp);
            list.remove(0);
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).equals(ss)){
                    Pair pair = new Pair();
                    pair.first = s;
                    pair.second = list.get(i);
                    list.remove(i);
                    result.add(pair);
                    break;
                }
            }
        }

        for(Pair p : result){
            System.out.println(p.toString());
        }


    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
