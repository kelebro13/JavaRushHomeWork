package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File folder = new File(root);
        List<String> fileTree = new ArrayList<>();
        Queue<File> queue = new ArrayDeque<>();

        Collections.addAll(queue, folder.listFiles());
        while(!queue.isEmpty()){
            File f = queue.poll();
            if(f.isDirectory()){
                Collections.addAll(queue, f.listFiles());
            }else{
                fileTree.add(f.getAbsolutePath());
            }
        }
        return fileTree;
    }

    public static void main(String[] args) throws IOException {
        List<String> list = getFileTree("/home/testim/Test");
        for(String s : list){
            System.out.println(s);
        }
    }
}
