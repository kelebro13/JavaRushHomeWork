package com.javarush.test.level33.lesson15.big01;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by testim on 22.04.16.
 */
public class Helper {
    public static String generateRandomString() {
        String s = new BigInteger(130, new SecureRandom()).toString(32);
        return s;
    }

    public static void printMessage(String message){
        System.out.println(message);
    }
}
