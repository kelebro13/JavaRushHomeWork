package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        FileWriter fw = new FileWriter(args[1], true);

        while(fr.ready()){
            String[] s1 = fr.readLine().split(" ");
            for(String s : s1) {
                byte[] tmp = s.getBytes();
                boolean check = false;
                for (byte b : tmp) {
                    if ((char) b >= 48 && (char) b <= 57) {
                        check = true;
                    }
                }

                if(check){
                    s = s + " ";
                    fw.write(s);
                }

            }

        }
        fr.close();
        fw.close();


    }
}
