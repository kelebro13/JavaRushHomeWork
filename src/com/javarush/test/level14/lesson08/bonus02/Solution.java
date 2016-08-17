package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int chislo1 = Integer.parseInt(reader.readLine());
        int chislo2 = Integer.parseInt(reader.readLine());

        int maxDel = 0;
        int maxLen = 0;

        if(chislo1 > chislo2){
            maxLen = chislo1;
        }else{
            maxLen = chislo2;
        }

        for(int i = 1; i <= maxLen; i++){
            if(chislo1%i == 0 && chislo2%i==0){
                maxDel = i;
            }
        }

        System.out.println(maxDel);
    }
}
