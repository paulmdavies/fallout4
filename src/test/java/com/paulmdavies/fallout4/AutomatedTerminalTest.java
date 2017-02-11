package com.paulmdavies.fallout4;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;


public class AutomatedTerminalTest {

    public static final List<Word> ANY_WORDS = Arrays.asList(new Word("test"));
    public static final Word ANY_PASSWORD = null;

    @Test(expected = AllPasswordsMustBeOfEqualLengthException.class)
    public void testShouldThrowExceptionIfNotAllWordsAreOfEqualLength() throws AllPasswordsMustBeOfEqualLengthException {
        new AutomatedTerminal(Arrays.asList(new Word("foo"), new Word("face")), ANY_PASSWORD);
    }

    @Test
    public void testValidateShouldDelegateToPasswordSimilarity() throws CannotCompareWordsOfDifferentLengthsException, AllPasswordsMustBeOfEqualLengthException {
        Word password = Mockito.spy(new Word("test"));
        AutomatedTerminal automatedTerminal = Mockito.spy(new AutomatedTerminal(ANY_WORDS, password));

        Word jeff = new Word("jeff");
        automatedTerminal.validate(jeff);
        verify(password).similarity(jeff);
    }

    @Test(expected = CannotCompareWordsOfDifferentLengthsException.class)
    public void testValidateShouldThrowExceptionIfGuessDoesNotMatchPasswordLength() throws CannotCompareWordsOfDifferentLengthsException, AllPasswordsMustBeOfEqualLengthException {
        AutomatedTerminal automatedTerminal = Mockito.spy(new AutomatedTerminal(ANY_WORDS, new Word("test")));

        automatedTerminal.validate(new Word("geoff"));
    }
}