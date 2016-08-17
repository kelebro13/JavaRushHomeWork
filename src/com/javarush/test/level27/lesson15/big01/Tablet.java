package com.javarush.test.level27.lesson15.big01;
import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by DNS on 17.02.2016.
 */
public class Tablet
{
    static Logger logger = Logger.getLogger(Tablet.class.getName());
    final int number;
    private LinkedBlockingQueue<Order> queue;


    public Tablet(int number)
    {
        this.number = number;
    }

    public void createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            printOrderAndP(order);
        }
        catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
    }

    public void createTestOrder(){
        TestOrder testOrder = null;
        try{
            testOrder = new TestOrder(this);
            printOrderAndP(testOrder);
        }catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + testOrder);
        }
    }

    private void printOrderAndP(Order testOrder) throws NoVideoAvailableException
    {
        if(!testOrder.isEmpty()){
            ConsoleHelper.writeMessage(testOrder.toString());
            new AdvertisementManager(testOrder.getTotalCookingTime() * 60).processVideos();
            try {
                queue.put(testOrder);
            }catch (InterruptedException ig){}
        }
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public String toString()
    {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
