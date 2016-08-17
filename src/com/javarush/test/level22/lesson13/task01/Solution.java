package com.javarush.test.level22.lesson13.task01;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        if(query == null)
        {
            return null;
        }

        if(delimiter == null){
            return new String[] {query};
        }

        List<String> list = new LinkedList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        while(stringTokenizer.hasMoreElements()){
            list.add(stringTokenizer.nextToken());
        }

        String[] s = new String[list.size()];

        return list.toArray(s);
    }

    public static void main(String[] args)
    {
        String s = "level22.lesson13.task01";
        String[] mass = getTokens(null, null);

        for(String ss : mass){
            System.out.println(ss);
        }

    }
}
