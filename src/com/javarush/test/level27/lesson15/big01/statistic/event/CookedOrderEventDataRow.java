package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.util.Date;
import java.util.List;

/**
 * Created by testim on 01.03.16.
 */
public class CookedOrderEventDataRow implements  EventDataRow {

    String tabletName;
    String cookName;
    int cookingTimeSeconds;
    List<Dish> cookingDishs;
    Date currentDate;

    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishs) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishs = cookingDishs;
        this.currentDate = new Date();
    }

    public String getCookName() {
        return cookName;
    }

    @Override
    public Date getDate() {
        return this.currentDate;
    }

    @Override
    public int getTime() {
        return this.cookingTimeSeconds;
    }

    @Override
    public EventType getType() {
        return EventType.COOKED_ORDER;
    }
}
