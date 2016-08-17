package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by DNS on 18.02.2016.
 */
public class Order
{
    protected List<Dish> dishes;
    Tablet userTablet;

    public Order(Tablet tablet) throws IOException
    {
        userTablet = tablet;
        initDishes();

    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public int getTotalCookingTime(){
        int time = 0;
        for(Dish dish : dishes){
            time += dish.getDuration();
        }
        return time; //minutes
    }

    public boolean isEmpty(){
        return dishes.size() == 0 ? true : false;
    }

    protected void initDishes() throws  IOException{
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString()
    {
        if(dishes.size() == 0){
            return "";
        }else
        {
            return "Your order: " + this.dishes + " of " + userTablet;
        }
    }

    public Tablet getUserTablet()
    {
        return userTablet;
    }
}
