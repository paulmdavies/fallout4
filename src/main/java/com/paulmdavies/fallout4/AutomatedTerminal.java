package com.paulmdavies.fallout4;

import java.util.List;
import java.util.stream.Collectors;

public class AutomatedTerminal implements Terminal {
    private final List<Word> words;
    private final Word password;

    public AutomatedTerminal(List<Word> words, Word password) throws AllPasswordsMustBeOfEqualLengthException {
        this.words = words;
        this.password = password;

        List<Integer> wordLengths = words.stream().map(Word::length).mapToInt(Integer::intValue).boxed().collect(Collectors.toList());
        if (wordLengths.stream().max(Integer::max).get() != wordLengths.stream().min(Integer::min).get()) {
            throw new AllPasswordsMustBeOfEqualLengthException();
        }
    }

    @Override
    public int validate(Word guess) throws CannotCompareWordsOfDifferentLengthsException {
        return password.similarity(guess);
    }
}
