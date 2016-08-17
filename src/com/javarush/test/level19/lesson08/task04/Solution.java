package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldOut = System.out;
        ByteArrayOutputStream text = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(text);
        System.setOut(newOut);

        testString.printSomething();

        System.setOut(oldOut);
        String ss = text.toString().replaceAll("\\p{Cntrl}", "");
        String[] s = ss.split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[2]);
        int result = 0;
        if(s[1].equals("+")){
            result = a + b;
        }else if(s[1].equals("-")){
            result = a - b;
        }else if(s[1].equals("*")){
            result = a * b;
        }
        ss = String.format("%s%d", ss, result);
        System.out.println(ss);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

