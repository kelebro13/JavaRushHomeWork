package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {

    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };


        List<Word> list = detectAllWords(crossword, "home", "same");

        for(Word w : list){
            System.out.println(w.toString());
        }


        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> list = new ArrayList<Word>();
        for (int i = 0; i < words.length; i++) {
            list.add(new Word(words[i]));
            int s = (int) words[i].charAt(0);
            for (int y = 0; y < crossword.length; y++) {
                for (int x = 0; x < crossword[0].length; x++) {
                    if (crossword[y][x] == s) {
                        searchWord(crossword, list.get(i), y, x);
                    }
                }
            }
        }
        return list;
    }

        public static void searchWord(int[][] crossword, Word  word, int y, int x){
            char[] letters = word.text.toCharArray();
            //search N
            try {
                for (int i = 0, yy = y; i < letters.length; i++, yy--) {
                    if (crossword[yy][x] != letters[i]) {
                        break;
                    }
                    if (crossword[yy][x] == letters[i] && i == letters.length - 1) {
                        word.setStartPoint(x, y);
                        word.setEndPoint(x, yy);
                    }
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}

            //search NO
            try {
                for (int i = 0, yy = y, xx = x; i < letters.length; i++, yy--, xx++) {
                    if (crossword[yy][xx] != letters[i]) {
                        break;
                    }
                    if (crossword[yy][xx] == letters[i] && i == letters.length - 1) {
                        word.setStartPoint(x, y);
                        word.setEndPoint(xx, yy);
                    }
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}

            //search O
            try {
                for (int i = 0, xx = x; i < letters.length; i++, xx++) {
                    if (crossword[y][xx] != letters[i]) {
                        break;
                    }
                    if (crossword[y][xx] == letters[i] && i == letters.length - 1) {
                        word.setStartPoint(x, y);
                        word.setEndPoint(xx, y);
                    }
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}

            //search OS
            try {
                for (int i = 0, yy = y, xx = x; i < letters.length; i++, yy++, xx++) {
                    if (crossword[yy][xx] != letters[i]) {
                        break;
                    }
                    if (crossword[yy][xx] == letters[i] && i == letters.length - 1) {
                        word.setStartPoint(x, y);
                        word.setEndPoint(xx, yy);
                    }
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}

            //search S
            try {
                for (int i = 0, yy = y; i < letters.length; i++, yy++) {
                    if (crossword[yy][x] != letters[i]) {
                        break;
                    }
                    if (crossword[yy][x] == letters[i] && i == letters.length - 1) {
                        word.setStartPoint(x, y);
                        word.setEndPoint(x, yy);
                    }
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}

            //search SW
            try {
                for (int i = 0, yy = y, xx = x; i < letters.length; i++, yy++, xx--) {
                    if (crossword[yy][xx] != letters[i]) {
                        break;
                    }
                    if (crossword[yy][xx] == letters[i] && i == letters.length - 1) {
                        word.setStartPoint(x, y);
                        word.setEndPoint(xx, yy);
                    }
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}

            //search W
            try {
                for (int i = 0, xx = x; i < letters.length; i++, xx--) {
                    if (crossword[y][xx] != letters[i]) {
                        break;
                    }
                    if (crossword[y][xx] == letters[i] && i == letters.length - 1) {
                        word.setStartPoint(x, y);
                        word.setEndPoint(xx, y);
                    }
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}

            //search WN
            try {
                for (int i = 0, yy = y, xx = x; i < letters.length; i++, yy--, xx--) {
                    if (crossword[yy][xx] != letters[i]) {
                        break;
                    }
                    if (crossword[yy][xx] == letters[i] && i == letters.length - 1) {
                        word.setStartPoint(x, y);
                        word.setEndPoint(xx, yy);
                    }
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}


        }




    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
