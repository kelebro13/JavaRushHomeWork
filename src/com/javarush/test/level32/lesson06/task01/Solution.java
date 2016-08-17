package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        char[] password = new char[8];
        String smallLetters = "QAZWSXEDCRFVTGBYHNUJMIKLOP";
        String number = "0123456789";
        String bigLetters = "qazwsxedcrfvtgbyhnujmikolp";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String tmp = smallLetters + number + bigLetters;

        while(true){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 8; i++){
                int j = (int)(Math.random() * (tmp.length()));
                sb.append(tmp.charAt(j));
            }

            if(checkPass(sb.toString(), smallLetters, bigLetters, number)){
                try {
                    baos.write(sb.toString().getBytes());
                } catch (IOException e) {
                }
                break;
            }
        }


        return baos;
    }

    private static boolean checkPass(String string, String smallLetters, String bigLetters, String number) {
        List<Character> pass = new ArrayList<Character>();
        for(char c : string.toCharArray()){
            pass.add(c);
        }

        List<Character> tmp = new ArrayList<>();
        for(char c : smallLetters.toCharArray()){
            tmp.add(c);
        }

        if(Collections.disjoint(pass, tmp)){
            return false;
        }

        tmp.clear();
        for(char c : bigLetters.toCharArray()){
            tmp.add(c);
        }

        if(Collections.disjoint(pass, tmp)){
            return false;
        }

        tmp.clear();
        for(char c : number.toCharArray()){
            tmp.add(c);
        }

        if(Collections.disjoint(pass, tmp)){
            return false;
        }

        return true;
    }

}
