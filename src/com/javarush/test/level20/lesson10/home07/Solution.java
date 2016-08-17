package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {

    public static void main(String[] args) throws Exception{
        String fileName = "C:\\Users\\DNS\\Desktop\\Java\\a.txt";
        Solution solution = new Solution(fileName);
        solution.writeObject("HEY");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DNS\\Desktop\\Java\\b.txt"));
        solution.writeObject(oos);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\DNS\\Desktop\\Java\\b.txt"));
        solution.readObject(ois);
        ois.close();
        solution.writeObject("THE END");
        solution.close();


    }


    transient private FileOutputStream stream;
    private String fileName;
    private static final long serialVersionUID = 1L;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(fileName);

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.fileName = (String)in.readObject();
        this.stream = new FileOutputStream(this.fileName, true);

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
