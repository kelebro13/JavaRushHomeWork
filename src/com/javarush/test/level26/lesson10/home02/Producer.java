package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Timur on 02.02.2016.
 */
public class Producer implements Runnable
{

    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    @Override
    public void run()
    {
        int i = 1;
        while(true)
        {

            try
            {
                String s = "Some text for " + i;
                map.put(String.valueOf(i), s);
                TimeUnit.MILLISECONDS.sleep(500);
                i++;
            }
            catch (Exception ig)
            {
                System.out.println(Thread.currentThread().getName() + " thread was terminated");
                break;
            }
        }
    }
}
