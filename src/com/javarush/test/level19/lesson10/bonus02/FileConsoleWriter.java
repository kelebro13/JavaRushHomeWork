package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter{
    private char[] buffer = new char[1024];




    public static void main(String[] args) throws IOException{
        FileConsoleWriter f = new FileConsoleWriter("C:\\Users\\DNS\\Desktop\\Java\\a.txt");
        FileWriter ff = new FileWriter("C:\\Users\\DNS\\Desktop\\Java\\b.txt");
//        int c = 58;
        char[] c = {'w','o','r','l','d','!',};
//        String c = "Hello!";
        f.write(c, 1, 3);
        ff.write(c, 1, 3);
        f.close();
        ff.close();

    }

    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(int c) throws IOException {
        buffer[0] = (char)c;
        System.out.println(String.valueOf((char)c));
        super.write(buffer, 0 ,1);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        String s = "";
        for(int i = off; i < off + len; i++){
            s += cbuf[i];
        }
        System.out.println(s);
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        char[] buff;
        if(len <= buffer.length){
            buff = buffer;
        }else{
            buff = new char[len];
        }
        str.getChars(off, (off + len), buff, 0);
        System.out.println(str.substring(off, (off + len)));
        super.write(buff, 0, len);
    }

    @Override
    public void write(char[] cbuf) throws IOException {
        String s = "";
        for(char c : cbuf){
            s += (char)c;
        }
        System.out.println(s);
        super.write(cbuf, 0, cbuf.length);
    }

    @Override
    public void write(String str) throws IOException {
        System.out.println(str);
        super.write(str, 0, str.length());
    }

    @Override
    public void close() throws IOException {
        super.close();
    }
}
