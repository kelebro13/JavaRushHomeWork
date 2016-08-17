package com.javarush.test.level28.lesson06.home01;

/**
 * Created by testim on 10.03.16.
 */
public class MyThread extends Thread {

    static int priorit = 1;

    public void genPrior() {
        if(priorit == 10){
            priorit = 1;
        }else{
            priorit++;
        }
    }

    public MyThread() {

        this.setPriority(priorit);
        genPrior();

    }



    public MyThread(Runnable target) {
        super(target);
        this.setPriority(priorit);
        genPrior();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        int priorGroup = group.getMaxPriority();
        if(priorGroup <= priorit){
            this.setPriority(priorGroup);
        }else{
            this.setPriority(priorit);
        }
        genPrior();


    }

    public MyThread(String name) {
        super(name);
        this.setPriority(priorit);
        genPrior();

    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        int priorGroup = group.getMaxPriority();
        if(priorGroup <= priorit){
            this.setPriority(priorGroup);
        }else{
            this.setPriority(priorit);
        }
        genPrior();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(priorit);
        genPrior();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        int priorGroup = group.getMaxPriority();
        if(priorGroup <= priorit){
            this.setPriority(priorGroup);
        }else{
            this.setPriority(priorit);
        }
        genPrior();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        int priorGroup = group.getMaxPriority();
        if(priorGroup <= priorit){
            this.setPriority(priorGroup);
        }else{
            this.setPriority(priorit);
        }
        genPrior();
    }
}
