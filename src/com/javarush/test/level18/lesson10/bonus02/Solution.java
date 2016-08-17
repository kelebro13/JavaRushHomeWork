package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        if(args[0].equals("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            FileInputStream fileRead = new FileInputStream(fileName);

            String fileReadData = "";
            while(fileRead.available() > 0){
                fileReadData += (char)fileRead.read();
            }
            fileRead.close();
            ArrayList<Long> listMaxId = new ArrayList<Long>();
            String[] massFileReadData = fileReadData.split("\n");

            for(int i = 0; i < massFileReadData.length; i++){
                try{
                    long l = Long.parseLong(massFileReadData[i].substring(0, 8).replaceAll(" ", ""));
                    listMaxId.add(l);
                }catch (StringIndexOutOfBoundsException e){

                }
            }

            Long maxId = Collections.max(listMaxId);
            if(maxId < 99999999) {

                String id = String.format("%n%-8.8s" ,(maxId + 1));
                String productName = "";
                for (int i = 1; i < args.length - 2; i++) {
                    productName += args[i] + " ";
                }
                productName = String.format("%-30.30s", productName);
                String price = String.format("%-8.8s", args[args.length - 2]);
                String quantity = String.format("%-4.4s", args[args.length - 1]);

                FileOutputStream fileWrite = new FileOutputStream(fileName, true);
                fileWrite.write((id + productName + price + quantity).getBytes());
                fileWrite.close();

            }else{
                System.out.println("Error - no memory!");
            }

        }


    }

}
