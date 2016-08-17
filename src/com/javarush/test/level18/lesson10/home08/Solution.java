package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String fileName = reader.readLine();
            if(fileName.equals("exit")){
                break;
            }else{
                new ReadThread(fileName);
            }
        }

        for(Map.Entry<String, Integer> pair : resultMap.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        reader.close();

    }

    public static class ReadThread extends Thread{
        private String fileName;

        public ReadThread(String fileName) throws Exception{
            this.fileName = fileName;
            resultMap.put(this.fileName, getInt());

            //implement constructor body
        }

        public int getInt() throws Exception{
            FileInputStream file = new FileInputStream(this.fileName);
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            while(file.available() > 0){
                int tmp = file.read();
                if(map.containsKey(tmp)){
                    int value = map.get(tmp) + 1;
                    map.put(tmp, value);
                }else{
                    map.put(tmp, 1);
                }
            }

            int byteIsGreater = 0;
            int byteCount = 0;

            for(Map.Entry<Integer, Integer> pair : map.entrySet()){
                int value = pair.getValue();
                if(value > byteCount){
                    byteCount = value;
                    byteIsGreater = pair.getKey();
                }
            }
            file.close();

            return byteIsGreater;
        }// implement file reading here - реализуйте чтение из файла тут
    }
}
