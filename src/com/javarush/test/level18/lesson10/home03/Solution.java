package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        FileOutputStream file1 = new FileOutputStream(s);
        FileInputStream file2 = new FileInputStream(reader.readLine());
        FileInputStream file3 = new FileInputStream(reader.readLine());

        while(file2.available() > 0){
            file1.write(file2.read());
        }

        file1 = new FileOutputStream(s, true);

        while(file3.available() > 0){
            file1.write(file3.read());
        }
        reader.close();
        file1.close();
        file2.close();
        file3.close();
    }
}
