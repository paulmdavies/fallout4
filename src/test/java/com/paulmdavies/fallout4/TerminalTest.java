package com.paulmdavies.fallout4;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;


public class TerminalTest {

    public static final List<Word> ANY_WORDS = Arrays.asList(new Word("test"));
    public static final Word ANY_PASSWORD = null;

    @Test(expected = AllPasswordsMustBeOfEqualLengthException.class)
    public void testShouldThrowExceptionIfNotAllWordsAreOfEqualLength() throws AllPasswordsMustBeOfEqualLengthException {
        new Terminal(Arrays.asList(new Word("foo"), new Word("face")), ANY_PASSWORD);
    }

    @Test
    public void testValidateShouldDelegateToPasswordSimilarity() throws CannotCompareWordsOfDifferentLengthsException, AllPasswordsMustBeOfEqualLengthException {
        Word password = Mockito.spy(new Word("test"));
        Terminal terminal = Mockito.spy(new Terminal(ANY_WORDS, password));

        Word jeff = new Word("jeff");
        terminal.validate(jeff);
        verify(password).similarity(jeff);
    }

    @Test(expected = CannotCompareWordsOfDifferentLengthsException.class)
    public void testValidateShouldThrowExceptionIfGuessDoesNotMatchPasswordLength() throws CannotCompareWordsOfDifferentLengthsException, AllPasswordsMustBeOfEqualLengthException {
        Terminal terminal = Mockito.spy(new Terminal(ANY_WORDS, new Word("test")));

        terminal.validate(new Word("geoff"));
    }
}