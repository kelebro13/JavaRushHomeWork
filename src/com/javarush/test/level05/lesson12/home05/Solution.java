package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int chislo = 0, sum = 0;
        String prov = "сумма", slovo;




        while(true){

            slovo = sc.readLine();
            boolean proverka;
            try{
                Integer.parseInt(slovo);
                proverka = true;
            }catch (NumberFormatException e){
                proverka = false;
            }
            if(proverka){
                chislo = Integer.parseInt(slovo);
                sum = sum + chislo;

            }else{
                if(slovo.equals(prov)){
                    break;
                }
            }


        }
        System.out.println(sum);

        ;//напишите тут ваш код
    }
}
