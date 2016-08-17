package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by DNS on 08.02.2016.
 */
class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String login = ConsoleHelper.readString();
            String pass = ConsoleHelper.readString();
            if (login.length() != 12 || pass.length() != 4 || login == null || pass == null)
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            } else
            {
                if(validCreditCards.containsKey(login)){
                    if(validCreditCards.getString(login).equals(pass))
                    {

                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), login));
                        break;
                    }else{
                        ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), login));
                    }

                }else{
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                }


            }
        }
    }
}
