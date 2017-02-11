package com.paulmdavies.fallout4;

public class Keyboard {
    private final Terminal terminal;

    public Keyboard(Terminal terminal) {

        this.terminal = terminal;
    }

    public int enter(Word guess) throws CannotCompareWordsOfDifferentLengthsException {
        return terminal.validate(guess);
    }
}
