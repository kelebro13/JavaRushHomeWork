package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by testim on 01.03.16.
 */
public interface EventDataRow {

    EventType getType();

    Date getDate();

    int getTime();
}
