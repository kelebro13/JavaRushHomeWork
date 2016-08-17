package com.javarush.test.level20.lesson02.task03;


import java.io.*;
import java.nio.Buffer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<String, String>();


    public void fillInPropertiesMap() throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        Properties p = new Properties();
        p.load(file);
        Enumeration enumeration = p.keys();
        while(enumeration.hasMoreElements()){
            String key = enumeration.nextElement().toString();
            String value = p.getProperty(key);
            properties.put(key, value);
        }
        reader.close();
        file.close();
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        if(properties.size() != 0) {
            Properties p = new Properties();
            for(Map.Entry<String, String> pair : properties.entrySet()){
                String key = pair.getKey();
                String value = pair.getValue();
                p.put(key, value);
            }
            p.save(outputStream, null);
        }
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        BufferedReader file = new BufferedReader(new InputStreamReader(inputStream));
        Properties p = new Properties();
        p.load(file);
        Enumeration enumeration = p.keys();
        while(enumeration.hasMoreElements()){
            String key = enumeration.nextElement().toString();
            String value = p.getProperty(key);
            properties.put(key, value);
        }
        file.close();
        //implement this method - реализуйте этот метод
    }
}
