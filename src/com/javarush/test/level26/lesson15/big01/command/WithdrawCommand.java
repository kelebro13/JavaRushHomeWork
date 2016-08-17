package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Timur on 05.02.2016.
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.askCurrencyCode()); // 1.1 and 1.2
        while(true){ //1.3
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            try
            {
                int sum = Integer.parseInt(ConsoleHelper.readString());
                if (currencyManipulator.isAmountAvailable(sum)) // 1.3.3
                {
                    try
                    {
                        Map<Integer, Integer> tmp = currencyManipulator.withdrawAmount(sum); //1.3.4
                        StringBuilder stringBuilder = new StringBuilder();
                        for (Map.Entry<Integer, Integer> map : tmp.entrySet())
                        {
                            stringBuilder.append(map.getKey() + " - " + map.getValue());
                            stringBuilder.append("\t");
                        }

                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), sum ,currencyManipulator.getCurrencyCode() ));
                        ConsoleHelper.writeMessage(stringBuilder.toString());
                        break;
                    }catch (NotEnoughMoneyException ignored){
                        ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                    }

                } else
                {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                }
            }catch (NumberFormatException ignored){
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            }
        }
    }
}
