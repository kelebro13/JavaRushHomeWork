package com.javarush.test.level22.lesson05.home01;

public class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else
            if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
                System.out.println(getFormattedStringForSecondThread(t, e, string));
            } else {
                System.out.println(getFormattedStringForOtherThread(t, e, string));
            }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        //todo
        return e.getClass().getSimpleName()+ " : " + e.getMessage() + " : " +t.getName();
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        String error = null;
        try
        {
            char c = string.charAt( -1);
        }catch (Exception ee){
            error = ee.toString();
        }
        return error + " : " + e.getClass().getSimpleName()+ " : " + t.getName();
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        String error = null;
        try
        {
            char c = string.charAt( -1);
        }catch (Exception ee){
            error = ee.toString();
        }
        return t.getName() + " : " + e.getClass().getSimpleName() + " : " + error;
    }
}

