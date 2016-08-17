package com.javarush.test.level32.lesson04.home01;

import java.io.*;

/* Читаем из потока
Реализуйте логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("/home/testim/Test/result.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter stringWriter = new StringWriter();
        if(is != null) {
            InputStreamReader isr = new InputStreamReader(is);
            char[] data = new char[Character.MAX_VALUE];
            int count;
            while (isr.ready()) {
                count = isr.read(data);
                stringWriter.write(data, 0, count);
            }
            isr.close();
        }
        return stringWriter;

    }
}
