package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        int s1 = 398;
        int s2 = 501234567;
        String tmp1 = String.format("%+d", s1);
        String tmp2 = String.format("%010d", s2);
        String tmp = String.format("%s(%s)%s-%s-%s", tmp1, tmp2.substring(0, 3), tmp2.substring(3, 6), tmp2.substring(6, 8), tmp2.substring(8,10));
        System.out.println(tmp);
    }


    public static class IncomeDataAdapter implements Customer, Contact {

        private IncomeData incomeData;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.incomeData = incomeData;
        }

        @Override
        public String getName() {
            return this.incomeData.getContactLastName() + ", " + this.incomeData.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            int s1 = this.incomeData.getCountryPhoneCode();
            int s2 = this.incomeData.getPhoneNumber();
            String tmp1 = String.format("%+d", s1);
            String tmp2 = String.format("%010d", s2);
            String tmp = String.format("%s(%s)%s-%s-%s", tmp1, tmp2.substring(0, 3), tmp2.substring(3, 6), tmp2.substring(6, 8), tmp2.substring(8,10));
            return tmp;
        }

        @Override
        public String getCompanyName() {
            return this.incomeData.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(this.incomeData.getCountryCode());
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}