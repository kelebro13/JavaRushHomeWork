package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {

    public static ArrayList<String> list = new ArrayList<String>();
    public static void main(String[] args) throws Exception{

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            reader = new BufferedReader(new FileReader(fileName));
            while(reader.ready()){
                String s = reader.readLine();
                if(s == null){
                    break;
                }
                list.add(s);
            }
        reader.close();



        if(args[1].length() <= 8) {
            for (int i = 0; i < list.size(); i++) {
                if(args[1].equals(list.get(i).substring(0, 8).replaceAll(" ", ""))){
                    if(args[0].equals("-u")){
                        list.remove(i);
                        list.add(i, getUpdateString(args));
                    }else if(args[0].equals("-d")){
                        list.remove(i);
                    }
                }
            }

            BufferedWriter fileWrite = new BufferedWriter(new FileWriter(fileName));
            for(String s : list){
                fileWrite.write(s + "\r\n");
            }
            fileWrite.close();
        }

    }

    public static String getUpdateString(String[] args){
        String s = "";
        String productName = "";
        for(int i  = 2; i < args.length - 2; i++){
            productName += args[i] + " ";
        }
        s = String.format("%-8.8s%-30.30s%-8.8s%-4.4s",args[1], productName, args[args.length-2], args[args.length - 1]);
        return s;
    }

}
