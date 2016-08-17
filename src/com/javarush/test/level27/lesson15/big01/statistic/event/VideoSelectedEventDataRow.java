package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;

import java.util.Date;
import java.util.List;

/**
 * Created by testim on 01.03.16.
 */
public class VideoSelectedEventDataRow implements  EventDataRow {

    List<Advertisement> optimalVideoSet;
    long amount;
    int totalDuration;
    Date currentDate;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public Date getDate() {
        return this.currentDate;
    }

    @Override
    public int getTime() {
        return this.totalDuration;
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }
}
