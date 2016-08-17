package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by testim on 12.04.16.
 */
public class HTMLFileFilter extends FileFilter {

    @Override
    public boolean accept(File file) {
        if(file.isDirectory()){
            return true;
        }else{
            String s = file.getName().substring(file.getName().lastIndexOf("."));
            if(s.toLowerCase().equals(".html")){
                return true;
            }else if(s.toLowerCase().equals(".htm")){
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {

        return "HTML и HTM файлы";
    }
}
