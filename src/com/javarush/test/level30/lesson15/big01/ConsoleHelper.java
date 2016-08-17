package com.javarush.test.level30.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by testim on 22.03.16.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String readString = "";
        while (true) {
            try {
                readString = bufferedReader.readLine();
                break;
            } catch (IOException ig) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return readString;
    }

    public static int readInt(){
        int i = 0;
        while (true) {
            try {
                i = Integer.parseInt(readString());
                break;
            } catch (NumberFormatException ig) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return i;
    }
}
