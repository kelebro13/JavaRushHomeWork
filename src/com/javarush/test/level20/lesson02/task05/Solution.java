package com.javarush.test.level20.lesson02.task05;

import java.io.*;
/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(java.lang.String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("tmp", ".txt", new File("C:\\Users\\DNS\\Desktop\\Java"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4


            loadedObject.load(inputStream);
            loadedObject.string1.print();
            loadedObject.string2.print();
            //check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            PrintStream oldOut = System.out;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream newOut = new PrintStream(byteArrayOutputStream);
            System.setOut(newOut);
            java.lang.String s1;
            if(string1 != null || string2 != null) {
                this.string1.print();
                this.string2.print();
                 s1 = byteArrayOutputStream.toString();
                writer.println(s1);
            }
            System.setOut(oldOut);
            writer.close();


            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int tmp = countStrings;
            int st1 = Integer.parseInt(reader.readLine().replace("string #", ""));
            countStrings = st1 - 1;
            this.string1 = new String();
            int st2 = Integer.parseInt(reader.readLine().replace("string #", ""));
            countStrings = st2 - 1;
            this.string2 = new String();
            countStrings = tmp;
            reader.close();
            //implement this method - реализуйте этот метод
        }
    }

    public static int countStrings;

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
