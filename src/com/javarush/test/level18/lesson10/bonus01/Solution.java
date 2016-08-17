package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception {

        FileInputStream fileRead = new FileInputStream(args[1]);
        FileOutputStream fileWrite = new FileOutputStream(args[2]);

        if(args[0].equals("-e")){
            byte[] buff = new byte[fileRead.available()];
            while(fileRead.available() > 0){
                fileRead.read(buff);
            }
            setEncryption(buff);
            fileWrite.write(buff);

        }
        if(args[0].equals("-d")){
            byte[] buff = new byte[fileRead.available()];
            while(fileRead.available() > 0){
                fileRead.read(buff);
            }
            setDecryption(buff);
            fileWrite.write(buff);

        }

        fileRead.close();
        fileWrite.close();
    }

    public static void setEncryption(byte[] buff){
        String key = "SuperTimEncryption";
        byte[] keyBuff = key.getBytes();
        for(int i = 0, j = 0; i < buff.length; i++, j++){
            if(j < keyBuff.length) {
                int tmp = buff[i] + keyBuff[j];
                buff[i] = (byte) tmp;
            }else{
                j=0;
            }
        }

    }

    public static void setDecryption(byte[] buff){
        String key = "SuperTimEncryption";
        byte[] keyBuff = key.getBytes();
        for(int i = 0, j = 0; i < buff.length; i++, j++){
            if(j < keyBuff.length) {
                int tmp = buff[i] - keyBuff[j];
                buff[i] = (byte) tmp;
            }else{
                j=0;
            }
        }

    }


}
