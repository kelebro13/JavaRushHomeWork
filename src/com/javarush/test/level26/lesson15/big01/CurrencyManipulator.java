package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Timur on 04.02.2016.
 */
public class CurrencyManipulator
{
    String currencyCode;
    Map<Integer, Integer> denominations = new HashMap<Integer, Integer>();

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination))
        {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else
        {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount()
    {
        int sum = 0;
        for (Map.Entry<Integer, Integer> map : denominations.entrySet())
        {
            sum += (map.getKey() * map.getValue());
        }
        return sum;
    }

    public boolean hasMoney()
    {
        return denominations.size() == 0 ? false : true;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return getTotalAmount() - expectedAmount >= 0 ? true : false;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        Comparator<Integer> comparator = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;
            }
        };

        Map<Integer, Integer> mapSort = new TreeMap<Integer, Integer>(comparator);
        mapSort.putAll(denominations);

        Map<Integer, Integer> tmp = new TreeMap<Integer, Integer>(comparator);

        int sum = expectedAmount;
        for (Map.Entry<Integer, Integer> map : mapSort.entrySet())
        {
            int value = map.getValue();
            for (int i = 0; i < value; i++)
            {
                sum = sum - map.getKey();
                if (sum == 0)
                {
                    if(tmp.get(map.getKey()) == null){
                        tmp.put(map.getKey(), 0);
                    }
                    tmp.put(map.getKey(), tmp.get(map.getKey()) + 1);
                    break;
                } else if (sum > 0)
                {
                    if(tmp.get(map.getKey()) == null){
                        tmp.put(map.getKey(), 0);
                    }
                    tmp.put(map.getKey(), tmp.get(map.getKey()) + 1);
                }else{
                    sum = sum + map.getKey();
                    break;
                }
            }
            if (sum == 0)
            {
                break;
            }
        }

        if (sum == 0) // 2.2 good
        {
            for(Map.Entry<Integer, Integer> map : tmp.entrySet()){
                int denomination =  map.getKey();
                int countTake = map.getValue();
                int count = denominations.get(denomination);
                if(count == countTake){
                    denominations.remove(denomination);
                }else{
                    denominations.put(denomination, count - countTake);
                }
            }
            return tmp;
        } else
        {
            throw new NotEnoughMoneyException();
        }
    }


}
