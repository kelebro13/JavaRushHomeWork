package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by testim on 24.03.16.
 */
public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        BotSocketThread botSocketThread = new BotSocketThread();
        return botSocketThread;
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        int xx = new Random().nextInt(100);
        return "date_bot_" + xx;
    }


    public class BotSocketThread extends SocketThread {

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if(message.contains(":"))
            {
                String[] splitMessage = message.split(": ");
                if (splitMessage.length == 2)
                {
                    SimpleDateFormat format = null;
                    if (splitMessage[1].equals("дата"))
                    {
                        format = new SimpleDateFormat("d.MM.YYYY");
                    }
                    if (splitMessage[1].equals("день"))
                    {
                        format = new SimpleDateFormat("d");
                    }
                    if (splitMessage[1].equals("день"))
                    {
                        format = new SimpleDateFormat("d");
                    }
                    if (splitMessage[1].equals("месяц"))
                    {
                        format = new SimpleDateFormat("MMMM");
                    }
                    if (splitMessage[1].equals("год"))
                    {
                        format = new SimpleDateFormat("YYYY");
                    }
                    if (splitMessage[1].equals("время"))
                    {
                        format = new SimpleDateFormat("H:mm:ss");
                    }
                    if (splitMessage[1].equals("час"))
                    {
                        format = new SimpleDateFormat("H");
                    }
                    if (splitMessage[1].equals("минуты"))
                    {
                        format = new SimpleDateFormat("m");
                    }
                    if (splitMessage[1].equals("секунды"))
                    {
                        format = new SimpleDateFormat("s");
                    }
                    if (format != null)
                    {
                            sendTextMessage("Информация для " + splitMessage[0] + ": " + format.format(Calendar.getInstance().getTime()));
                    }
                }
            }

        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    }

}
