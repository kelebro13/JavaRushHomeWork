package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map <String, byte[]> map = new TreeMap<String, byte[]>();
        FileInputStream file = null;
        FileOutputStream fileWrite;
        while(true){
            String fileName = reader.readLine();
            if(fileName.equals("end")){
                String fileNameTmp = "";
                for(Map.Entry<String, byte[]> pair : map.entrySet()){
                    String tmp = pair.getKey();
                    fileNameTmp = tmp.substring(0, tmp.length()-6);
                }
                File newFile = new File(fileNameTmp);
                newFile.createNewFile();
                fileWrite = new FileOutputStream(fileNameTmp);
                for(Map.Entry<String, byte[]> pair : map.entrySet()){
                    byte[] buff = pair.getValue();
                    fileWrite.write(buff);
                }
                break;
            }else{
                file = new FileInputStream(fileName);
                byte[] buff = new byte[file.available()];
                while(file.available() > 0){
                    file.read(buff);
                }
                map.put(fileName, buff);
            }
        }

        file.close();
        fileWrite.close();
        reader.close();

    }
}
