package com.javarush.test.level27.lesson15.big01.ad;

import java.util.*;

/**
 * Created by Timur on 06.03.2016.
 */
public class StatisticAdvertisementManager
{
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance()
    {
        return ourInstance;
    }

    private StatisticAdvertisementManager()
    {
    }

    public Set<Advertisement> getVideoSet(boolean b){
        Set<Advertisement> set = new HashSet<Advertisement>();
        for(Advertisement a : storage.list()){
            if(b)
            {
                if (a.getHits() >= 1)
                {
                    set.add(a);
                }
            }else{
                if(a.getHits() == 0){
                    set.add(a);
                }
            }
        }
        return set;
    }
}
