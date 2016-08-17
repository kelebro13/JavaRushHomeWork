package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IllegalFormatException;
import java.util.ResourceBundle;

/**
 * Created by Timur on 04.02.2016.
 */
public class ConsoleHelper //класс для работы с консолью и текстом
{
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException{
        String string = "";
        try{
            string = bufferedReader.readLine();
            if(string.toUpperCase().equals("EXIT")){
                writeMessage(res.getString("the.end"));
                throw new InterruptOperationException();
            }
        }catch (IOException ignored){}
        return string;
        }

    public static String askCurrencyCode() throws InterruptOperationException{
        writeMessage(res.getString("choose.currency.code"));
        String currencyCode = "";
        while(true){
            currencyCode = readString();
            if(currencyCode.length() != 3){
                writeMessage(res.getString("invalid.data"));
            }else{
                currencyCode = currencyCode.toUpperCase();
                break;
            }
        }
        return currencyCode;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{

        String [] twoDigits;
        writeMessage(res.getString("choose.denomination.and.count.format"));
        while(true){
            int denomination;
            int count;
            twoDigits = readString().split(" ");
            try
            {

                denomination = Integer.parseInt(twoDigits[0]);
                count = Integer.parseInt(twoDigits[1]);
            }catch (Exception ignored){
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if(denomination <= 0 || count <= 0 || twoDigits.length > 2){
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return twoDigits;
    }

    public static Operation askOperation() throws InterruptOperationException{
        writeMessage(res.getString("choose.operation"));
        writeMessage("1 - " + res.getString("operation.INFO")  +
                ", 2 - "+ res.getString("operation.DEPOSIT")  +
                ", 3 - "+ res.getString("operation.WITHDRAW")  +
                ", 4 - "+ res.getString("operation.EXIT"));
        Operation operation;
        while(true){
            try
            {
                int i = Integer.parseInt(readString());
                operation = Operation.getAllowableOperationByOrdinal(i);

                break;
            }catch(IllegalArgumentException ignored)
            {

                writeMessage(res.getString("invalid.data"));
            }

        }
        return operation;
    }
    public static void printExitMessage(){
        writeMessage(res.getString("the.end"));
    }
}
