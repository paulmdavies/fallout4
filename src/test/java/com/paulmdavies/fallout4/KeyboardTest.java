package com.paulmdavies.fallout4;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class KeyboardTest {
    @Test
    public void testEnterShouldDelegateToTerminalValidation() throws CannotCompareWordsOfDifferentLengthsException {
        Terminal terminal = Mockito.spy(Terminal.class);
        Keyboard keyboard = new Keyboard(terminal);

        Word guess = new Word("foo");
        when(terminal.validate(guess)).thenReturn(100);

        int similarity = keyboard.enter(guess);
        verify(terminal).validate(guess);
        assertEquals(similarity, 100);
    }

    @Test
    public void testEnterShouldReturnValueReturnedByTerminalValidation() throws CannotCompareWordsOfDifferentLengthsException {
        Terminal terminal = Mockito.spy(Terminal.class);
        Keyboard keyboard = new Keyboard(terminal);

        Word guess = new Word("foo");
        when(terminal.validate(guess)).thenReturn(100);

        int similarity = keyboard.enter(guess);
        assertEquals(similarity, 100);
    }
}