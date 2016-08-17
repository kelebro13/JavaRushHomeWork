package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader urlString = new BufferedReader(new InputStreamReader(System.in));
        String urlStringChange = urlString.readLine();
        int i = urlStringChange.indexOf("?");
        String nURL = urlStringChange.substring(i + 1);
        String[] param = nURL.split("&");

        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> listAlert = new ArrayList<String>();

        for(int j = 0; j < param.length; j++){
            if(param[j].contains("=")){
                String[] tmp = param[j].split("=");
                list.add(tmp[0]);
                if(tmp[0].equals("obj")) {
                    listAlert.add(tmp[1]);
                }
            }else{
                list.add(param[j]);
            }
        }

        for(String t : list){
            System.out.print(t + " ");
        }
        System.out.println();

        for(String m : listAlert){
            try{
                alert(Double.parseDouble(m));
            }catch(Exception e){
                alert(m);
            }
        }

        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
