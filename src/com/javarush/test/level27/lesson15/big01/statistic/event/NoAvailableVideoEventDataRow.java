package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by testim on 01.03.16.
 */
public class NoAvailableVideoEventDataRow implements  EventDataRow {

    int totalDuration;
    Date currentDate;

    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
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
        return EventType.NO_AVAILABLE_VIDEO;
    }
}
