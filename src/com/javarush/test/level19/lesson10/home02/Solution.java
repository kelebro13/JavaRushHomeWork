package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader fr = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new HashMap<String, Double>();
        while(fr.ready()){
            String[] line = fr.readLine().split(" ");
            if(map.containsKey(line[0])){
                double tmp = map.get(line[0]) + Double.parseDouble(line[1]);
                map.put(line[0], tmp);

            }else{
                map.put(line[0], Double.parseDouble(line[1]));
            }
        }
        double max = Collections.max(map.values());

        for(Map.Entry<String, Double> pair: map.entrySet()){
            double tmp = pair.getValue();
            if(tmp == max){
                System.out.println(pair.getKey());
            }
        }

        fr.close();
    }
}
