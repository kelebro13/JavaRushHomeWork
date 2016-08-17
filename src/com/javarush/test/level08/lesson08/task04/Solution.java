package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stallone", new Date("JULE 1 1980"));
        map.put("Stallone", new Date("AUGUST 1 1980"));
        map.put("Stallone", new Date("MAY 1 1980"));
        map.put("Stallone", new Date("MAY 1 1980"));
        map.put("Stallone", new Date("MAY 1 1980"));
        map.put("Stallone", new Date("MAY 1 1980"));
        map.put("Stallone", new Date("MAY 1 1980"));
        map.put("Stallone", new Date("MAY 1 1980"));
        map.put("Stallone", new Date("JUNE 1 1980"));

        return (HashMap <String, Date>) map;

        //напишите тут ваш код

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            Date month = pair.getValue();

            if(month.getMonth() > 4 && month.getMonth() < 8) map.remove(month);

        }//напишите тут ваш код

    }
}