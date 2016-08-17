package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Timur on 29.09.2015.
 */
public class Singleton
{
    private static Singleton singleton;
    public static Singleton getInstance(){
        return singleton;
    }

    private Singleton(){

    }
}
