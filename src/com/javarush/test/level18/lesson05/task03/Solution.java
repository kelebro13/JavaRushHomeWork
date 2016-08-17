package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());
        FileOutputStream file3 = new FileOutputStream(reader.readLine());

        byte[] buff = new byte[file1.available()];
        int count = 0;

        while(file1.available() > 0){
            count = file1.read(buff);
        }

        if(count % 2 == 0){
            int from = count/2;
            file2.write(buff, 0, (count/2));
            file3.write(buff, from, (count - from));

        }else{
            int from = count/2 + 1;
            file2.write(buff, 0, (count/2 + 1));
            file3.write(buff, from, (count - from));
        }

        reader.close();
        file1.close();
        file2.close();
        file3.close();


    }
}
