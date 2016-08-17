package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.util.Map;
import java.util.TreeMap;


public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream file = new FileInputStream(args[0]);
        byte[] buff = new byte[file.available()];
        while(file.available() > 0){
            file.read(buff);
        }

        TreeMap<Byte, Integer> map = new TreeMap<Byte, Integer>();
        for(byte b : buff){
            if(b >= 0 && b <= 127){
                if(map.containsKey(b)){
                    int value = map.get(b) + 1;
                    map.put(b, value);
                }else{
                    map.put(b, 1);
                }
            }
        }

        for(Map.Entry<Byte, Integer> pair : map.entrySet()){
            byte b = pair.getKey();
            System.out.println((char)b + " " + pair.getValue());
        }

        file.close();

    }
}
