package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by DNS on 20.02.2016.
 */
public class Cook extends Observable implements Runnable {
    String name;
    private LinkedBlockingQueue<Order> queue;
    private boolean stop = false;
    private boolean caught = false;

    public Cook(String name) {
        this.name = name;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void startCookingOrder(Order order) {

        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", order.toString(), order.getTotalCookingTime()));
        StatisticEventManager statisticEventManager = StatisticEventManager.getInstance();
        statisticEventManager.register(new CookedOrderEventDataRow(order.getUserTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes()));
        try {
            Thread.sleep(order.getTotalCookingTime() * 10);
        } catch (InterruptedException e) {
            caught = true;
        }
        setChanged();
        notifyObservers(order);


    }


    @Override
    public void run() {

        while(!stop){

                try {
                    startCookingOrder(queue.take());
                } catch (InterruptedException ig) {
                    caught = true;
                }


            if(caught && queue.isEmpty()){
                stop = true;
            }

        }


    }

    @Override
    public String toString() {
        return name;
    }
}
