package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;


import java.util.Locale;


/**
 * Created by Timur on 04.02.2016.
 */
public class CashMachine
{
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);
        try
        {

        Operation operation = Operation.LOGIN;
        CommandExecutor.execute(operation);

            do
            {

                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);


            }
            while (!operation.equals(Operation.EXIT));
        }catch (InterruptOperationException ignored)
        {
            ConsoleHelper.printExitMessage();
        }

    }
}
