package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by testim on 03.03.16.
 */
public class DirectorTablet {

    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit(){
        Map <Date, Double> map = StatisticEventManager.getInstance().getAdvertisementProfit();
        double total = 0d;

        for(Map.Entry<Date,Double> m : map.entrySet()){
            Date date = m.getKey();
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", format.format(date), m.getValue()));
            total += m.getValue();
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", total));

    }

    public void printCookWorkloading(){
        Map<Date, Map<String, Integer>> map = StatisticEventManager.getInstance().getCookWorkloading();
        for(Map.Entry<Date, Map<String, Integer>> m : map.entrySet()){
            ConsoleHelper.writeMessage(format.format(m.getKey()));
            for(Map.Entry<String, Integer> mm : m.getValue().entrySet()){
                    ConsoleHelper.writeMessage(String.format("%s - %d min", mm.getKey(), mm.getValue()));
                }
            }
            ConsoleHelper.writeMessage("");
        }


    public void printActiveVideoSet(){
        Set<Advertisement> set = new TreeSet<Advertisement>(new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                String s1 = o1.getName();
                String s2 = o2.getName();
                return s1.compareToIgnoreCase(s2);
            }
        });
        for(Advertisement a : StatisticAdvertisementManager.getInstance().getVideoSet(true)){
            set.add(a);
        }

        for(Advertisement a : set){
            ConsoleHelper.writeMessage(String.format("%s - %d", a.getName(), a.getHits()));
        }
        ConsoleHelper.writeMessage("");
    }

    public void printArchivedVideoSet(){

        Set<Advertisement> set = new TreeSet<Advertisement>(new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                String s1 = o1.getName();
                String s2 = o2.getName();
                return s1.compareToIgnoreCase(s2);
            }
        });
        for(Advertisement a : StatisticAdvertisementManager.getInstance().getVideoSet(false)){
            set.add(a);
        }

        for(Advertisement a : set){
            ConsoleHelper.writeMessage(a.getName());
        }
        ConsoleHelper.writeMessage("");
    }
}
