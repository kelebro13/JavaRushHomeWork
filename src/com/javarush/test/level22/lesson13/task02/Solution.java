package com.javarush.test.level22.lesson13.task02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution
{
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException
    {

        Charset win = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");


       FileInputStream fis = new FileInputStream(args[0]);
        byte[] buffer = new byte[fis.available()];
            while (fis.available() > 0) {
                fis.read(buffer);
            }
        fis.close();

        String s = new String(buffer, utf8);
        buffer = s.getBytes(win);

        FileOutputStream fos = new FileOutputStream(args[1]);
        fos.write(buffer);
        fos.close();
    }
}
