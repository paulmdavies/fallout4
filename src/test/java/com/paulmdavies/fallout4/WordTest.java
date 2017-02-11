package com.paulmdavies.fallout4;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordTest {
    @Test
    public void testSimilarityBetweenWordsShouldBeTheNumberOfCharactersTheyShareInTheSamePosition() throws CannotCompareWordsOfDifferentLengthsException {
        Word foo = new Word("Foo");
        Word boo = new Word("Boo");
        assertEquals(foo.similarity(boo), 2);
    }

    @Test
    public void testSimilarityShouldBeCalculatedRegardlessOfCase() throws CannotCompareWordsOfDifferentLengthsException {
        Word foo = new Word("Foo");
        Word far = new Word("far");
        assertEquals(foo.similarity(far), 1);
    }

    @Test(expected = CannotCompareWordsOfDifferentLengthsException.class)
    public void testShouldThrowAnExceptionWhenComparingWordsOfDifferentLengths() throws CannotCompareWordsOfDifferentLengthsException {
        Word foo = new Word("foo");
        Word face = new Word("face");

        foo.similarity(face);
    }

    @Test
    public void testLengthShouldReturnLengthOfUnderlyingWord() {
        Word foo = new Word("foo");

        assertEquals(foo.length(), 3);
    }
}