package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string){
        if(string == null) throw new TooShortStringException();

        int begin = string.indexOf(" ");
        if(begin == -1) throw new TooShortStringException();

        int finish = begin;
        int count = 0;
        while (count < 4){
            finish = string.indexOf(" ", finish + 1);
            count++;
            if(finish == -1) break;

        }

        if(finish == -1) throw new TooShortStringException();

        String tmp = string.substring(begin + 1, finish);
        return tmp;

    }

    public static class TooShortStringException extends RuntimeException {
        public TooShortStringException(String message)
        {
            super(message);
        }

        public TooShortStringException()
        {
            super();
        }
    }

    public static void main(String[] args){
        String s ="JavaRush - лучший сервис";
        System.out.println(getPartOfString(s));
    }
}
