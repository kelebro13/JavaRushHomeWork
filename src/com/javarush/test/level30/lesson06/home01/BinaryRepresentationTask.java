package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.RecursiveTask;

/**
 * Created by testim on 21.03.16.
 */
public class BinaryRepresentationTask extends RecursiveTask {
    private int i;

    public BinaryRepresentationTask(int i) {
        this.i = i;
    }


    @Override
    protected String compute() {
        if(i <= 1){
            return new String("" + i);
        }
        BinaryRepresentationTask b1 = new BinaryRepresentationTask(i % 2);
        b1.fork();
        BinaryRepresentationTask b2 = new BinaryRepresentationTask(i / 2);
        return new String(b2.compute() + b1.join());
    }
}
