package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        int countGap = 0;
        int i = file.available();
        while(file.available() > 0){
            char c = (char)file.read();
            if(c == ' '){
                countGap++;
            }
        }

        double var = (double)countGap / i * 100;
        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String tmp = decimalFormat.format(var);
        tmp = tmp.replace(",", ".");
        System.out.println(tmp);

        file.close();



    }
}
