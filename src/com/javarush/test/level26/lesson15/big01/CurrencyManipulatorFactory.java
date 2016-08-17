package com.javarush.test.level26.lesson15.big01;


import java.util.*;

/**
 * Created by Timur on 04.02.2016.
 */
public class CurrencyManipulatorFactory
{
    static Map<String, CurrencyManipulator> mapManipulators = new HashMap<String, CurrencyManipulator>();
    private CurrencyManipulatorFactory()
    {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        CurrencyManipulator currencyManipulator = null;

        for(Map.Entry<String, CurrencyManipulator> map : mapManipulators.entrySet()){
            if(currencyCode.equals(map.getKey())){
                currencyManipulator = map.getValue();
            }
        }
        if(currencyManipulator == null){
            currencyManipulator = new CurrencyManipulator(currencyCode);
            mapManipulators.put(currencyCode, currencyManipulator);
        }
        return currencyManipulator;
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        ArrayList<CurrencyManipulator> listManipulators = new ArrayList<CurrencyManipulator>();
        for(Map.Entry<String, CurrencyManipulator> map : mapManipulators.entrySet()){
            listManipulators.add(map.getValue());
        }
        return listManipulators;
    }
}
