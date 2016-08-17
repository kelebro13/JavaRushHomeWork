package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by DNS on 17.02.2016.
 */


public class Restaurant
{
    private final static int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<Order>();

    public static void main(String[] args) {
        Waitor waitor = new Waitor();

        Cook cook = new Cook("Amigo");
        cook.setQueue(queue);
        cook.addObserver(waitor);

        Cook cook2 = new Cook("Ivanov");
        cook2.setQueue(queue);
        cook2.addObserver(waitor);

        Thread cookThread = new Thread(cook);
        Thread cook2Thread = new Thread(cook2);

        cookThread.start();
        cook2Thread.start();
        List<Tablet> tablets = new ArrayList<Tablet>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i + 1);
            tablet.setQueue(queue);
            tablets.add(tablet);
        }
        Thread thread = new Thread(new ThreadLocalRandom(tablets, ORDER_CREATING_INTERVAL));
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        thread.interrupt();
        cookThread.interrupt();
        cook2Thread.interrupt();

        try{
            cookThread.join();
            cook2Thread.join();
        }catch (InterruptedException ig){

        }

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }

}
