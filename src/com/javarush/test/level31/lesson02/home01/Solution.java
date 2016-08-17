package com.javarush.test.level31.lesson02.home01;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {

    static List<File> filesLessThan50Bytes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        File folder = new File(args[0]);
        File oldFile = new File(args[1]);
        getAllFilesLessThan50Bytes(folder);
        if(filesLessThan50Bytes.contains(oldFile)){
            filesLessThan50Bytes.remove(oldFile);
        }

        Collections.sort(filesLessThan50Bytes, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String name1 = o1.getName();
                String name2 = o2.getName();
                return name1.compareTo(name2);
            }
        });

        Path source = Paths.get(args[1]);
        Path newFile = Files.move(source, source.resolveSibling("allFilesContent.txt"));

        BufferedWriter bw = new BufferedWriter(new FileWriter(newFile.toFile()));
        for(File f : filesLessThan50Bytes){
            BufferedReader br = new BufferedReader(new FileReader(f));
            while(br.ready()){
                bw.write(br.readLine());
                bw.newLine();
            }
            br.close();
        }
        bw.close();

    }


    public static void getAllFilesLessThan50Bytes(File folder) {
        for(File f : folder.listFiles()){
            if(f.isDirectory()){
                if(f.listFiles().length == 0){
                    f.delete();
                }else{
                    getAllFilesLessThan50Bytes(f);
                }
            }else{
                if(f.length() > 50){
                    f.delete();
                }else{
                    filesLessThan50Bytes.add(f);
                }
            }
        }
    }
}
