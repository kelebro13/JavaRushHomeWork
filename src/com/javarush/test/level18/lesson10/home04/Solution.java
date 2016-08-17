package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Name = reader.readLine();
        FileInputStream file1read = new FileInputStream(file1Name);
        byte[] buff = new byte[file1read.available()];
        while(file1read.available() > 0){
            file1read.read(buff);
        }
        file1read.close();

        FileOutputStream file1write = new FileOutputStream(file1Name);
        FileInputStream file2 = new FileInputStream(reader.readLine());
        while(file2.available() > 0){
            file1write.write(file2.read());
        }

        file1write = new FileOutputStream(file1Name, true);

        file1write.write(buff);

        file2.close();
        file1write.close();
        reader.close();

    }
}
