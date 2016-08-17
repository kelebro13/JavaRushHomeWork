package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        //...

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br = new BufferedReader(new FileReader(fileName));
        List<String> list = new LinkedList<>();
        while(br.ready()){
            String [] fileData = br.readLine().split(" ");
            Collections.addAll(list, fileData);
        }
        br.close();

        Collections.shuffle(list);

        String[] tmp = new String [list.size()];
        tmp = list.toArray(tmp);

        StringBuilder result = getLine(tmp);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if(words == null || words.length == 0){
            return new StringBuilder();
        }

        if(words[0].equals("")){
            return new StringBuilder(words[0]);
        }
        List<String> list = new LinkedList<>();
        Collections.addAll(list, words);

        while(!isOk(list)){
            Collections.shuffle(list);
        }
        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb;
    }

    public static boolean isOk(List<String> list){

        for(int i = 0; i < list.size()- 1; i++){
            String s1 = list.get(i);
            String s2 = list.get(i + 1);
            if(s1.toLowerCase().charAt(s1.length() - 1) != s2.toLowerCase().charAt(0)){
                return false;
            }
        }
        return true;
    }

    //мое решение (очень большое)
    //    public static StringBuilder getLine(String... words) {
//        if(words.length == 0){
//            return new StringBuilder();
//        }
//        List<String> list = new LinkedList<String>();
//        for(String s : words){
//            list.add(s);
//        }
////        Collections.sort(list);
//
//        StringBuilder sb = new StringBuilder();
//        List<String> list2 = new LinkedList<String>();
//        int x = 0;
//        String s = list.get(0);
//        do{
//            list.remove(s);
//            char finish = s.toUpperCase().toLowerCase().charAt(s.length() - 1);
//            for(int i = 0; i < list.size(); i++){
//                String s2 = list.get(i);
//                if(!s2.equals(s))
//                {
//                    char begin = list.get(i).toUpperCase().toLowerCase().charAt(0);
//                    if (finish == begin)
//                    {
//                        if (!list2.contains(s))
//                        {
//                            list2.add(s);
//                        }
//                        list2.add(s2);
//                        s = s2;
//                        list.remove(s2);
//                        break;
//                    } else
//                    {
//                        if (i == list.size() - 1)
//                        {
//                            list.add(s);
//                            x++;
//                            s = list.get(0);
//                            break;
//                        }
//                    }
//                }
//            }
//
//
//        }while(x < list.size());
//
//
//        for(String sss : list2){
//            sb.append(sss);
//            sb.append(" ");
//        }
//        if(sb.length() != 0)
//        {
//            sb.replace(sb.length() - 1, sb.length(), "");
//        }
//        return sb;
//    }


//    //решение подсмотренное и доработаное
//    public static StringBuilder getLine(String... words) {
//        if(words == null || words.length == 0){
//            return new StringBuilder();
//        }
//
//        if(words[0].equals("")){
//            return new StringBuilder(words[0]);
//        }
//        List<String> list = new LinkedList<>();
//        Collections.addAll(list, words);
//        StringBuilder sb = new StringBuilder();
//        sb.append(list.get(0));
//        int len = sb.length();
//        list.remove(0);
//
//        int x = 0;
//        while(list.size() > 0){
//            for(int i = 0; i < list.size(); i++){
//                String a = list.get(i).toUpperCase().toLowerCase();
//                String b = sb.toString().toUpperCase().toLowerCase();
//                if(a.charAt(0) == b.charAt(sb.length() - 1)){
//                    sb.append(" ").append(list.get(i));
//                    list.remove(i);
//                }else if(b.charAt(0) == a.charAt(a.length() - 1)){
//                    sb.insert(0, " ");
//                    sb.insert(0, list.get(i));
//                    list.remove(i);
//                }else{
//                    if(i == list.size() - 1){
//                        x++;
//                    }
//                }
//
//            }
//
//            if(x > list.size()){
//                break;
//            }
//
//        }
//        return sb;
//    }

}



