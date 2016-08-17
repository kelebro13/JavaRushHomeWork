package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        ArrayList<Character> list = new ArrayList<Character>();
        while(file.available() > 0){
            int c = file.read();
            if((c >= 65 && c <= 90) || ( c >= 97 && c <= 122)) {
                if (!list.contains(c)) {
                    list.add((char)c);
                }
            }
        }

        System.out.println(list.size());

        file.close();

    }
}
