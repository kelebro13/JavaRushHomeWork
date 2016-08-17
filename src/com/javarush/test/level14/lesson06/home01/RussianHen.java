package com.javarush.test.level14.lesson06.home01;

/**
 * Created by DNS on 22.09.2015.
 */
public class RussianHen extends Hen
{
    public int getCountOfEggsPerMonth(){
        return 1000;
    }

    public String getDescription(){
        return RussianHen.super.getDescription()+ " ћо€ страна - " + Country.RUSSIA +" я несу " + getCountOfEggsPerMonth() + " €иц в мес€ц.";
    }
}
