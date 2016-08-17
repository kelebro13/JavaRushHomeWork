package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        byte[] buff = new byte[file.available()];
        while(file.available() > 0){
            file.read(buff);
        }

        String[] tmp2 =(new String(buff)).split("\n");
        ArrayList<MyMap> list = new ArrayList<MyMap>();
        for(int i = 0; i < tmp2.length; i++){
            list.add(new MyMap(tmp2[i]));
        }

        for(MyMap m : list){
            int i = Integer.parseInt(args[0]);
            if(m.getId() == i){
                m.print();
            }
        }


        file.close();
        reader.close();
    }

    public static class MyMap{

        private int id;
        private String productName;
        private double price;
        private int quality;

        public MyMap(String string) {

            String[] tmp = string.split(" ");
            String productName = "";
            for(int i = 1; i < tmp.length - 2; i++){
                productName += tmp[i] + " ";
            }

            this.id = Integer.parseInt(tmp[0]);
            this.productName = productName;
            this.price = Double.parseDouble(tmp[tmp.length - 2]);
            this.quality = (int)Double.parseDouble(tmp[tmp.length - 1]);
        }

        public int getId(){
            return  this.id;
        }

        public void print(){
            System.out.println(this.id + " " + this.productName + " " + this.price + " " + this.quality);
        }
    }
}
