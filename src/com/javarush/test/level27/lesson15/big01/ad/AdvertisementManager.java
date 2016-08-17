package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Created by DNS on 20.02.2016.
 */
public class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos()
    {

        List<Advertisement> allVideo = new ArrayList<Advertisement>();
        for(Advertisement a : storage.list()){
            if(a.getHits() > 0){
                allVideo.add(a);
            }
        }

        List<Advertisement> list = find(allVideo, new ArrayList<Advertisement>(), timeSeconds, 0);

        if(list.isEmpty()){
            StatisticEventManager.getInstance().register(new NoAvailableVideoEventDataRow(timeSeconds));
            throw new NoVideoAvailableException();
        }

        Collections.sort(list, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                if (o1.getAmountPerOneDisplaying() != o2.getAmountPerOneDisplaying())
                {
                    return Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                }
                else
                {
                    long l1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                    long l2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();
                    return Long.compare(l1, l2);
                }
            }
        });

        //amount for StatisticEventManager
        long amount = 0;
        int time = 0;
        for(Advertisement a : list){
            amount += a.getAmountPerOneDisplaying();
            time += a.getDuration();

        }

        //creat StatisticEventManager for Video
        StatisticEventManager.getInstance().register(new VideoSelectedEventDataRow(list, amount, time));

        for (Advertisement a : list)
        {

            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                    a.getName(),
                    a.getAmountPerOneDisplaying(),
                    (a.getAmountPerOneDisplaying() * 1000) / a.getDuration()));
            a.revalidate();
        }

    }


    public List<Advertisement> find(List<Advertisement> allVideo, List<Advertisement> list, int time, int i) {
        if (i == allVideo.size()) {
            return list;
        } else if (time <= 0) {
            return list;
        } else {
                Advertisement video = allVideo.get(i);
                List<Advertisement> list1 = new ArrayList<Advertisement>();
                list1.addAll(list);
                List<Advertisement> list2 = new ArrayList<Advertisement>();
                list2.addAll(list);
                list1 = find(allVideo, list1, time, i + 1);
                if (video.getDuration() <= time)
                {
                    list2.add(video);
                    list2 = find(allVideo, list2, time - video.getDuration(), i + 1);
                }
                return max(list1, list2);

        }


    }

    public List<Advertisement> max(List<Advertisement> l1, List<Advertisement> l2) {
        int l1time = 0;
        int l1sum = 0;
        int l1count = 0;
        for (Advertisement i : l1) {
            l1time += i.getDuration();
            l1sum += i.getAmountPerOneDisplaying();
            l1count += 1;
        }

        int l2time = 0;
        int l2sum = 0;
        int l2count = 0;
        for (Advertisement i : l2) {
            l2time += i.getDuration();
            l2sum += i.getAmountPerOneDisplaying();
            l2count += 1;
        }

        if (l1sum != l2sum) {
            return l1sum > l2sum ? l1 : l2;
        } else if (l1time != l2time) {
            return l1time > l2time ? l1 : l2;
        } else {
            return l1count > l2count ? l2 : l1;
        }

    }


    
}




