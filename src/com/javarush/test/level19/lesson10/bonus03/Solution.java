package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(!args[0].equals("CDATA")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String arg = args[0];
            int len = arg.length() + 3;
            BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
            reader.close();
            String s = "";
            while (file.ready()) {
                s += file.readLine() + " ";
            }

            Pattern st = Pattern.compile("<" + arg + "((\\s.+?>)|(>))");
            Matcher stM = st.matcher(s);
            ArrayList<Integer> listSt = new ArrayList<Integer>();
            while(stM.find()){
                listSt.add(stM.start());
            }

            Pattern fn = Pattern.compile("</" + arg + ">");
            Matcher fnM = fn.matcher(s);
            ArrayList<Integer> listFn = new ArrayList<Integer>();
            while(fnM.find()){
                listFn.add(fnM.start());
            }

            int count = 0;
            while(listSt.size() > 0) {
                if (listSt.size() == 1) {
                    System.out.println(s.substring(listSt.get(0), listFn.get(0) + len));
                    listSt.remove(0);
                    listFn.remove(0);
                    count = 0;
                } else {
                    for (int i = 0; i < listSt.size(); i++) {
                        if (listFn.get(0) > listSt.get(i)) {
                            count++;
                        } else {
                            if (count > 1) {
                                System.out.println(s.substring(listSt.get(0), listFn.get(count) + len));
                                listSt.remove(0);
                                listFn.remove(count);
                                count = 0;
                            } else {
                                System.out.println(s.substring(listSt.get(0), listFn.get(0) + len));
                                listSt.remove(0);
                                listFn.remove(0);
                                count = 0;
                            }
                        }

                    }

                    if (count == listSt.size()) {
                        System.out.println(s.substring(listSt.get(0), listFn.get(count - 1) + len));
                        listSt.remove(0);
                        listFn.remove(count - 1);
                        count = 0;
                    }

                }
            }



            file.close();
        }
    }
}
