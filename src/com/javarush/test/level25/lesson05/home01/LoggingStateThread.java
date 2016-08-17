package com.javarush.test.level25.lesson05.home01;

import sun.security.pkcs11.wrapper.CK_ATTRIBUTE;

/**
 * Created by DNS on 21.01.2016.
 */
public class LoggingStateThread extends Thread
{
    Thread thread;

    public LoggingStateThread(Thread thread)
    {

        this.thread = thread;
        setDaemon(true);

    }

    @Override
    public void run()
    {
        State state = thread.getState();
        System.out.println(state);
        while (state != State.TERMINATED)
        {
            if (state != thread.getState())
            {
                state = thread.getState();
                System.out.println(state);
            }
        }
    }

}
