package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by testim on 01.03.16.
 */
public class StatisticEventManager
{

    StatisticStorage statisticStorage = new StatisticStorage();
    private static StatisticEventManager instance = new StatisticEventManager();

    private StatisticEventManager(){}

    public static StatisticEventManager getInstance(){
        return instance;
    }

    public void register(EventDataRow data){
        if(data == null){
            return;
        }
        this.statisticStorage.put(data);
    }

    public Map<Date, Double> getAdvertisementProfit(){
        List<EventDataRow> list = statisticStorage.getListForEventType(EventType.SELECTED_VIDEOS);
        Map<Date, Double> map = new TreeMap<Date, Double>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });
        for(EventDataRow e : list){
            Date date = getDate(e.getDate());
            double d = (double)((VideoSelectedEventDataRow)e).getAmount() / 100;
            if(map.containsKey(date)){
                double l = map.get(date);
                map.put(date, l + d);
            }else{
                map.put(date, d);
            }
        }
        return map;
    }

    public Map<Date, Map<String, Integer>> getCookWorkloading(){
        List<EventDataRow> list = statisticStorage.getListForEventType(EventType.COOKED_ORDER);
        Map<Date, Map<String, Integer>> map = new TreeMap<Date, Map<String, Integer>>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });
        for(EventDataRow e : list){
            Date date = getDate(e.getDate());
            CookedOrderEventDataRow c = (CookedOrderEventDataRow) e;
            int time = c.getTime();
            if(time == 0){
                continue;
            }
            if(time % 60 == 0){
                time = time / 60;
            }else{
                time = time / 60 + 1;
            }
            if(map.containsKey(date)){
                Map<String, Integer> tmp = map.get(date);
                if(tmp.containsKey(c.getCookName())){
                    int total = tmp.get(c.getCookName());
                    tmp.put(c.getCookName(), total + time);
                }else{
                    tmp.put(c.getCookName(), time);
                }

            }else{
                Map<String, Integer> tmp = new TreeMap<String, Integer>();
                tmp.put(c.getCookName(), time);
                map.put(date, tmp);
            }
        }
        return map;
    }

    public Date getDate(Date date){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.HOUR_OF_DAY, 0);
        gregorianCalendar.set(Calendar.MINUTE, 0);
        gregorianCalendar.set(Calendar.SECOND, 0);
        gregorianCalendar.set(Calendar.MILLISECOND, 0);
        return gregorianCalendar.getTime();
    }
    private class StatisticStorage{
        Map<EventType, List<EventDataRow>> map;

        public StatisticStorage() {
            this.map = new HashMap<EventType, List<EventDataRow>>();
            for(EventType eventType : EventType.values()){
                this.map.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data){
            this.map.get(data.getType()).add(data);
        }

        private List<EventDataRow> getListForEventType(EventType eventType){
            return map.get(eventType);
        }
    }
}
