package com.paulmdavies.fallout4;

public class Word {

    private final String word;

    public Word(String word) {
        this.word = word;
    }

    public int similarity(Word otherWord) {
        String lowerCaseWord = word.toLowerCase();
        String lowerCaseOtherWord = otherWord.word.toLowerCase();
        int counter = 0;
        for (int i = 0; i < lowerCaseWord.length(); i++) {
            if (lowerCaseWord.charAt(i) == lowerCaseOtherWord.charAt(i)) {
                counter++;
            }
        }
        return counter;
    }
}
