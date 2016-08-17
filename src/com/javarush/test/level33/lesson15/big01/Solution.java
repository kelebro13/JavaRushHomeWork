package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;
import com.javarush.test.level33.lesson15.big01.tests.FunctionalTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Мабель on 23.04.2016.
 */
public class Solution
{
    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> keys = new LinkedHashSet<>();
        for(String s : strings){
            keys.add(shortener.getId(s));
        }
        return keys;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> strings = new LinkedHashSet<>();
        for(Long l : keys){
            strings.add(shortener.getString(l));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings = new LinkedHashSet<>();
        for(long l = 0; l < elementsNumber; l++){
            strings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Date startDate = new Date();
        Set<Long> testKeys = getIds(shortener, strings);
        Date finishDate = new Date();
        Helper.printMessage((finishDate.getTime() - startDate.getTime()) + "");

        startDate = new Date();
        Set<String> testStrings = getStrings(shortener, testKeys);
        finishDate = new Date();
        Helper.printMessage((finishDate.getTime() - startDate.getTime()) + "");

        if(strings.containsAll(testStrings)){
            Helper.printMessage("Тест пройден.");
        }else{
            Helper.printMessage("Тест не пройден."); 
        }

    }

    public static void main(String[] args)
    {
//        testStrategy(new HashMapStorageStrategy(), 10000);
//        testStrategy(new OurHashMapStorageStrategy(), 10000);
//        //testStrategy(new FileStorageStrategy(), 100);
//        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
//        testStrategy(new HashBiMapStorageStrategy(), 10000);
//        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);

        JUnitCore runner = new JUnitCore();
        Result result = runner.run(FunctionalTest.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }
}
