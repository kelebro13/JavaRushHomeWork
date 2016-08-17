package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        ArrayList<String> listfile1 = new ArrayList<String>();
        while(file1.ready() ){
            listfile1.add(file1.readLine());
        }
        file1.close();

        ArrayList<String> listfile2 = new ArrayList<String>();
        while(file2.ready()){
            listfile2.add(file2.readLine());
        }
        file2.close();

        int f1 = 0, f2 = 0;
        while(f1 < listfile1.size() && f2 < listfile2.size()){
            if (listfile1.get(f1).equals(listfile2.get(f2))) {
                lines.add(new LineItem(Type.SAME, listfile2.get(f2)));
                System.out.println("SAME " + listfile1.get(f1));
                f1++;
                f2++;
            }else if (f1 < listfile1.size() - 1 && listfile1.get(f1 + 1).equals(listfile2.get(f2))) {
                lines.add(new LineItem(Type.REMOVED, listfile1.get(f1)));
                System.out.println("REMOVED " + listfile1.get(f1));
                f1++;


            }else if (f1 > 0 && listfile1.get(f1 - 1).equals(listfile2.get(f2))) {
                    lines.add(new LineItem(Type.REMOVED, listfile1.get(f1)));
                    System.out.println("REMOVED " + listfile1.get(f1));
                    f1++;


            } else {
                    lines.add(new LineItem(Type.ADDED, listfile2.get(f2)));
                    System.out.println("ADDED " + listfile2.get(f2));
                    f2++;
            }
        }

        if(f1 < listfile1.size()){
            lines.add(new LineItem(Type.REMOVED, listfile1.get(f1)));
            System.out.println("REMOVED " + listfile1.get(f1));
            f1++;
        }
        if(f2 < listfile2.size()){
            lines.add(new LineItem(Type.ADDED, listfile2.get(f2)));
            System.out.println("ADDED " + listfile2.get(f2));
            f2++;
        }


    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
