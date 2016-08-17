package com.javarush.test.level19.lesson03.task05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.SimpleFormatter;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();

    static{
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {

        String fullName = "+3(050)123-45-67";
        fullName = "callto://" + fullName.substring(0, fullName.length() - 14)
                + fullName.substring(fullName.length() - 13, fullName.length()-10)
                + fullName.substring(fullName.length() - 9, fullName.length() - 6)
                + fullName.substring(fullName.length() - 5, fullName.length() - 3)
                + fullName.substring(fullName.length() - 2,fullName.length());
        //callto://+380501234567
        System.out.println(fullName);
    }

    public static class DataAdapter implements RowItem {

        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String key = "";
            for(Map.Entry<String, String> pair : countries.entrySet()){
                String value = pair.getValue();
                if(value.equals(this.customer.getCountryName())){
                    key = pair.getKey();
                    break;
                }
            }
            return key;
        }

        @Override
        public String getCompany() {
            return this.customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String firstName = this.contact.getName();
            firstName = firstName.substring(firstName.indexOf(" ") + 1, firstName.length());
            return firstName;
        }

        @Override
        public String getContactLastName() {
            String lastName = this.contact.getName();
            lastName = lastName.substring(0, lastName.indexOf(","));
            return lastName;
        }

        @Override
        public String getDialString() {
            String callto = this.contact.getPhoneNumber();
            callto = "callto://" + callto.substring(0, callto.length() - 14)
                    + callto.substring(callto.length() - 13, callto.length()-10)
                    + callto.substring(callto.length() - 9, callto.length() - 6)
                    + callto.substring(callto.length() - 5, callto.length() - 3)
                    + callto.substring(callto.length() - 2,callto.length());
            return callto;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
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