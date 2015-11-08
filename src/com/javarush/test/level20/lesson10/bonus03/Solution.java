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
        for (Word word : detectAllWords(crossword, "home", "same"))
            System.out.println(word.toString());
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordList = new ArrayList<Word>();
        char[] chars;

        boolean isOK;
        for (String word : words){
            chars = word.toCharArray();
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if ((int)chars[0] == crossword[i][j]){
                        if (i+1-chars.length >= 0){
                            isOK = true;
                            for (int k = chars.length - 1; k > 0 ; k--) {
                                if (!((int)chars[k] == crossword[i - k][j])){
                                    isOK = false;
                                    break;
                                }
                            }
                            if (isOK) {
                                Word wordTemp = new Word(word);
                                wordTemp.setStartPoint(j, i);
                                wordTemp.setEndPoint(j, i-(chars.length - 1));
                                wordList.add(wordTemp);
                            }
                        }
                        if (((i+1-chars.length) >= 0) &&
                                ((crossword[i].length - j - 1 - chars.length) >= 0)) {
                            isOK = true;
                            for (int k = chars.length - 1; k > 0 ; k--) {
                                if (!((int)chars[k] == crossword[i - k][j + k])){
                                    isOK = false;
                                    break;
                                }
                            }
                            if (isOK) {
                                Word wordTemp = new Word(word);
                                wordTemp.setStartPoint(j, i);
                                wordTemp.setEndPoint(j+(chars.length - 1), i-(chars.length - 1));
                                wordList.add(wordTemp);
                            }

                        }
                        if ((crossword[i].length - j - 1 - chars.length) >= 0) {
                            isOK = true;
                            for (int k = chars.length - 1; k > 0 ; k--) {
                                if (!((int)chars[k] == crossword[i][j + k])){
                                    isOK = false;
                                    break;
                                }
                            }
                            if (isOK) {
                                Word wordTemp = new Word(word);
                                wordTemp.setStartPoint(j, i);
                                wordTemp.setEndPoint(j+(chars.length - 1), i);
                                wordList.add(wordTemp);
                            }

                        }
                        if (((crossword[i].length - j - 1 - chars.length) >= 0) &&
                                ((crossword.length - i - 1 - chars.length) >= 0)){
                            isOK = true;
                            for (int k = chars.length - 1; k > 0 ; k--) {
                                if (!((int)chars[k] == crossword[i + k][j + k])){
                                    isOK = false;
                                    break;
                                }
                            }
                            if (isOK) {
                                Word wordTemp = new Word(word);
                                wordTemp.setStartPoint(j, i);
                                wordTemp.setEndPoint(j+(chars.length - 1), i+(chars.length - 1));
                                wordList.add(wordTemp);
                            }

                        }
                        if ((crossword.length - i - 1 - chars.length) >= 0) {
                            isOK = true;
                            for (int k = chars.length - 1; k > 0 ; k--) {
                                if (!((int)chars[k] == crossword[i + k][j])){
                                    isOK = false;
                                    break;
                                }
                            }
                            if (isOK) {
                                Word wordTemp = new Word(word);
                                wordTemp.setStartPoint(j, i);
                                wordTemp.setEndPoint(j, i+(chars.length - 1));
                                wordList.add(wordTemp);
                            }

                        }
                        if (((crossword.length - i - 1 - chars.length) >= 0) &&
                                (j+1-chars.length) >= 0){
                            isOK = true;
                            for (int k = chars.length - 1; k > 0 ; k--) {
                                if (!((int)chars[k] == crossword[i + k][j - k])){
                                    isOK = false;
                                    break;
                                }
                            }
                            if (isOK) {
                                Word wordTemp = new Word(word);
                                wordTemp.setStartPoint(j, i);
                                wordTemp.setEndPoint(j-(chars.length - 1), i+(chars.length - 1));
                                wordList.add(wordTemp);
                            }

                        }
                        if ((j+1-chars.length) >= 0) {
                            isOK = true;
                            for (int k = chars.length - 1; k > 0 ; k--) {
                                if (!((int)chars[k] == crossword[i][j - k])){
                                    isOK = false;
                                    break;
                                }
                            }
                            if (isOK) {
                                Word wordTemp = new Word(word);
                                wordTemp.setStartPoint(j, i);
                                wordTemp.setEndPoint(j-(chars.length - 1), i);
                                wordList.add(wordTemp);
                            }

                        }
                        if (((j+1-chars.length) >= 0) &&
                                (i+1-chars.length >= 0)) {
                            isOK = true;
                            for (int k = chars.length - 1; k > 0 ; k--) {
                                if (!((int)chars[k] == crossword[i - k][j - k])){
                                    isOK = false;
                                    break;
                                }
                            }
                            if (isOK) {
                                Word wordTemp = new Word(word);
                                wordTemp.setStartPoint(j, i);
                                wordTemp.setEndPoint(j-(chars.length - 1), i-(chars.length - 1));
                                wordList.add(wordTemp);
                            }

                        }
                    }
                }
            }
        }
        return wordList;
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
