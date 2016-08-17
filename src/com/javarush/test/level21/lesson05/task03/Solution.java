package com.javarush.test.level21.lesson05.task03;

import java.util.Date;

/* Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (aDouble != solution1.aDouble) return false;

        if(date != null && solution1.date == null){
            return false;
        }else if(date == null && solution1.date != null){
            return false;
        }else if(date != null && solution1.date != null){
            if(!date.equals(solution1.date)){
                return false;
            }
        }

        if(string != null && solution1.string == null){
            return false;
        }else if(string == null && solution1.string != null){
            return false;
        }else if(string != null && solution1.string != null){
            if(!string.equals(solution1.string)){
                return false;
            }
        }

        if(solution != null && solution1.solution == null){
            return false;
        }else if(solution == null && solution1.solution != null){
            return false;
        }else if(solution != null && solution1.solution != null){
            if(!solution.equals(solution1.solution)){
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int)(temp);
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        result = 31 * result + (string != null ? string.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public static void main(String[] args)
    {
        Solution s1 = new Solution(0, null, 0.0d, null, null);
        Solution s2 = new Solution(0, null, 0.0d, null, null);

        System.out.println(s1.equals(s2));
    }
}
