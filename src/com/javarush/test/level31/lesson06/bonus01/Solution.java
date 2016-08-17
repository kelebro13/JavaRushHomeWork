package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        String[] partZip = new String[args.length - 1];
        for(int i = 1; i < args.length; i++){
            partZip[i-1] = args[i];
        }
        Arrays.sort(partZip);
        List<FileInputStream> list = new ArrayList<>();
        for(String s : partZip){
            list.add(new FileInputStream(s));
        }

        SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(list));

        ZipInputStream zis = new ZipInputStream(sis);
        FileOutputStream fosLoc = new FileOutputStream(args[0]);
        ZipEntry ze;
        byte[] data = new byte[Byte.MAX_VALUE];
        int count;
        while((ze = zis.getNextEntry())!=null){
            while((count = zis.read(data))>-1){
                fosLoc.write(data, 0, count);
                fosLoc.flush();
            }
        }
        sis.close();
        zis.close();
        fosLoc.close();

    }
}
