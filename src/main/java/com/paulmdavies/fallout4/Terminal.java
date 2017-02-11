package com.paulmdavies.fallout4;

public interface Terminal {
    int validate(Word guess) throws CannotCompareWordsOfDifferentLengthsException;
}
