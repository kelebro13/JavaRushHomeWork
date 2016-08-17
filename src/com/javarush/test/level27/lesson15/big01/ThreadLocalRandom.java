package com.javarush.test.level27.lesson15.big01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timur on 06.03.2016.
 */
public class ThreadLocalRandom implements Runnable
{
    List<Tablet> tablets = new ArrayList<Tablet>();
    int interval;

    public ThreadLocalRandom(List<Tablet> tablets, int interval)
    {
        this.interval = interval;
        this.tablets = tablets;
    }

    @Override
    public void run()
    {
        while(!Thread.currentThread().isInterrupted()){
            try
            {
            int randomTablet = (int)(Math.random() * tablets.size());
            Tablet tablet = tablets.get(randomTablet);
            tablet.createTestOrder();
            Thread.sleep(interval);
            }catch (InterruptedException e){
                break;
            }
        }
    }
}
