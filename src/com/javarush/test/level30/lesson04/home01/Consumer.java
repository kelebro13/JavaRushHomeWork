package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Мабель on 20.03.2016.
 */
public class Consumer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try{
            Thread.sleep(500);


        while(!Thread.currentThread().isInterrupted()){
                ShareItem item = queue.take();
                System.out.println("Processing " + item.toString());
        }
        }catch (InterruptedException ig){}
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consumer consumer = (Consumer) o;

        return !(queue != null ? !queue.equals(consumer.queue) : consumer.queue != null);

    }

    @Override
    public int hashCode()
    {
        return queue != null ? queue.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return "Consumer{" +
                "queue=" + queue +
                '}';
    }
}
