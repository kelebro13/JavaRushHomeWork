package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by testim on 28.04.16.
 */
public class SpeedTest {

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date start = new Date();
        ids = new HashSet<>();
        for(String s : strings){
            ids.add(shortener.getId(s));
        }
        Date finish = new Date();
        return finish.getTime() - start.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date start = new Date();
        strings = new HashSet<>();
        for(Long l : ids){
            strings.add(shortener.getString(l));
        }
        Date finish = new Date();
        return finish.getTime() - start.getTime();
    }

    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        for(int i = 0; i < 10000; i++){
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> ids1 = new HashSet<>();
        for(String s : origStrings){
            ids1.add(shortener1.getId(s));
        }

        Set<Long> ids2 = new HashSet<>();
        for(String s : origStrings){
            ids2.add(shortener2.getId(s));
        }


        long time1 = getTimeForGettingIds(shortener1, origStrings, null);
        long time2 = getTimeForGettingIds(shortener2, origStrings, null);

        Assert.assertTrue(time1 > time2);

        time1 = getTimeForGettingStrings(shortener1, ids1, null);
        time2 = getTimeForGettingStrings(shortener2, ids2, null);

        Assert.assertEquals(time1, time2, 5);
    }
}
