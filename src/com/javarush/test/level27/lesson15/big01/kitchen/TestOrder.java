package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Timur on 06.03.2016.
 */
public class TestOrder extends Order
{
    public TestOrder(Tablet tablet) throws IOException
    {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException
    {
        dishes = new ArrayList<Dish>();
        for(int i = 0; i < 5; i++)
        {
            int k = (int) (Math.random() * Dish.values().length);
            dishes.add(Dish.values()[k]);
        }
    }
}
