package com.javarush.test.level19.lesson08.task01;

/* Ридер обертка
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна преобразовывать весь текст в заглавные буквы
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток.
Вывести модифицированную строку в консоль.
*/


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception{
        PrintStream oldOut = System.out;
        ByteArrayOutputStream text = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(text);
        System.setOut(newOut);
        testString.printSomething();
        System.setOut(oldOut);
        String result = text.toString().toUpperCase();
        System.out.println(result);



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
