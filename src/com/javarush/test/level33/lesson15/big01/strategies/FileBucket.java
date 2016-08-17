package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by testim on 26.04.16.
 */
public class FileBucket {

    Path path;

    public FileBucket() {
        try {
            this.path = Files.createTempFile("", ".tmp");
            File file = path.toFile();
            file.deleteOnExit();
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public long getFileSize() {
        long l = 0;
        try {
            l = Files.size(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        return l;
    }

    public void putEntry(Entry entry) {
        try {
            FileOutputStream fos = new FileOutputStream(path.toFile());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Entry entryTmp = entry;
            while (entryTmp != null) {
                oos.writeObject(entryTmp);
                if (entryTmp.next != null) {
                    entryTmp = entryTmp.next;
                } else {
                    entryTmp = null;
                }
            }
            oos.close();
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry() {

        if (getFileSize() == 0) {
            return null;
        }else {
            Entry entry = null;
            try {
                FileInputStream fis = new FileInputStream(path.toFile());
                ObjectInputStream ois = new ObjectInputStream(fis);
                entry = (Entry) ois.readObject();
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (ClassNotFoundException e) {
                ExceptionHandler.log(e);
            }
            return entry;
        }
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }


}
