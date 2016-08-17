package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        String tmp = "";
        while(file1.available() > 0){
            int tmpI = file1.read();
            tmp = tmp + (char)tmpI;
        }
        String[] ss = tmp.split(" ");
        String tmp2 = "";
        for(String s : ss){
            tmp2 = tmp2 + ((int) Math.round(Double.parseDouble(s))) + " ";
        }

        file1.close();
        FileOutputStream file2 = new FileOutputStream(reader.readLine());

        file2.write(tmp2.getBytes());

        file2.close();
        reader.close();
    }
}
