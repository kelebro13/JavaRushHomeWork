package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String pathFile = args[0];
        String pathZip = args[1];

        Map<ZipEntry, byte[]> map = new HashMap<>();

        ZipInputStream zis = new ZipInputStream(new FileInputStream(pathZip));
        ZipEntry entry;
        while((entry = zis.getNextEntry()) != null){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[Byte.MAX_VALUE];
            int count;
            while((count = zis.read(bytes)) != -1){
                baos.write(bytes, 0, count);
            }
            map.put(entry, baos.toByteArray());
        }

        zis.closeEntry();
        zis.close();

        Path file = Paths.get(pathFile);
        ZipEntry fileZip = new ZipEntry("new/" + file.getFileName());

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(pathZip));
        for(Map.Entry<ZipEntry, byte[]> pair : map.entrySet()){
            String s = pair.getKey().getName();
            zos.putNextEntry(new ZipEntry(s));
            if(s.equals(fileZip.getName())){
                zos.write(Files.readAllBytes(file));
                zos.closeEntry();
                continue;
            }
            zos.write(pair.getValue());
            zos.closeEntry();
        }

        zos.close();
    }
}
