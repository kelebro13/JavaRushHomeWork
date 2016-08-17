package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DNS on 19.02.2016.
 */
public class ConsoleHelper
{
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> orderList = new ArrayList<Dish>();
        writeMessage("Select dishs: " + Dish.allDishesToString());

        String userSelection = "";
        while(true){
            userSelection = readString();
            if(userSelection.toLowerCase().equals("exit")){
                break;
            }

            Dish[] dish = Dish.values();

            for(int i = 0; i < dish.length; i++){
                if (dish[i].toString().equals(userSelection)){
                    orderList.add(dish[i]);
                    break;
                }
                if(i == dish.length - 1){
                    writeMessage(userSelection + " is not detected");
                }
            }
        }
        return orderList;
    }
}
