package com.paulmdavies.fallout4;

public class Word {

    private final String word;

    public Word(String word) {
        this.word = word.toLowerCase();
    }

    public int similarity(Word otherWord) throws CannotCompareWordsOfDifferentLengthsException {
        if (word.length() != otherWord.word.length()) {
            throw new CannotCompareWordsOfDifferentLengthsException();
        }

        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == otherWord.word.charAt(i)) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }

    public int length() {
        return word.length();
    }
}
