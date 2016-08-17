package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by testim on 28.04.16.
 */
public class FunctionalTest {

        public void testStorage(Shortener shortener){
            String string1 = Helper.generateRandomString();
            String string2 = Helper.generateRandomString();
            String string3 = new String(string1);

            Long key1 = shortener.getId(string1);
            Long key2 = shortener.getId(string2);
            Long key3 = shortener.getId(string3);

            Assert.assertNotEquals(key2, key1);
            Assert.assertNotEquals(key2, key3);

            Assert.assertEquals(key1, key3);

            String result1 = shortener.getString(key1);
            String result2 = shortener.getString(key2);
            String result3 = shortener.getString(key3);

            Assert.assertEquals(string1, result1);
            Assert.assertEquals(string2, result2);
            Assert.assertEquals(string3, result3);
        }

    @Test
    public void testHashMapStorageStrategy(){
        testStorage(new Shortener(new HashMapStorageStrategy()));
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        testStorage(new Shortener(new OurHashMapStorageStrategy()));
    }

    @Test
    public void testFileStorageStrategy(){
        testStorage(new Shortener(new FileStorageStrategy()));
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        testStorage(new Shortener(new HashBiMapStorageStrategy()));
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        testStorage(new Shortener(new DualHashBidiMapStorageStrategy()));
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        testStorage(new Shortener(new OurHashBiMapStorageStrategy()));
    }
}
