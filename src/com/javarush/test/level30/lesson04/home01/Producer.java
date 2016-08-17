package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Мабель on 20.03.2016.
 */
public class Producer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        for (int i = 1; i < 10; i++)
        {
            if(Thread.currentThread().isInterrupted()){
                return;
            }
            System.out.format("Элемент 'ShareItem-%d' добавлен%n", i);
            queue.offer(new ShareItem("ShareItem-" + i, i));
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException ig)
            {
            }
            if (queue.hasWaitingConsumer())
            {
                System.out.println("Consumer в ожидании!");
            }
        }
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producer producer = (Producer) o;

        return !(queue != null ? !queue.equals(producer.queue) : producer.queue != null);

    }

    @Override
    public int hashCode()
    {
        return queue != null ? queue.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return "Producer{" +
                "queue=" + queue +
                '}';
    }
}
